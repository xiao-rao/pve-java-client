package io.github.pve.client.http;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.pve.client.exception.ProxmoxApiException;
import io.github.pve.client.config.AuthenticationConfig;
import io.github.pve.client.config.NodeConnectionConfig;
import io.github.pve.client.config.ProxmoxClientConfig;
import io.github.pve.client.exception.ProxmoxAuthException;
import io.github.pve.client.exception.ProxmoxException;
import io.github.pve.client.session.ProxmoxSession;
import io.github.pve.client.session.ProxmoxSessionManager;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.decorators.Decorators;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.vavr.control.Try;

import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * 负责执行对Proxmox VE API的HTTP请求。
 * 此类现在依赖于ProxmoxSessionManager来获取和管理会话。
 */
public class ProxmoxApiExecutor {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProxmoxApiExecutor.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .registerModule(new JavaTimeModule());

    private final ProxmoxClientConfig clientConfig;
    private final ProxmoxSessionManager sessionManager;
    private final OkHttpClient httpClient;
    private final ResilienceManager resilienceManager; // 新增韧性管理器


    public ProxmoxApiExecutor(ProxmoxClientConfig clientConfig,
                              ProxmoxSessionManager sessionManager,
                              OkHttpClient httpClient,
                              ResilienceManager resilienceManager) {
        this.clientConfig = Objects.requireNonNull(clientConfig, "ProxmoxClientConfig cannot be null");
        this.sessionManager = Objects.requireNonNull(sessionManager, "ProxmoxSessionManager cannot be null");
        this.httpClient = Objects.requireNonNull(httpClient, "OkHttpClient cannot be null");
        this.resilienceManager = resilienceManager;
    }

    public <T> PveResponse<T> get(String path, Map<String, String> qp, TypeReference<T> rt) {
        return execute("GET", path, qp, null, rt);
    }

    public <T> PveResponse<T> post(String path, Map<String, String> qp, Object b, TypeReference<T> rt) {
        return execute("POST", path, qp, b, rt);
    }

    public <T> PveResponse<T> put(String path, Map<String, String> qp, Object b, TypeReference<T> rt) {
        return execute("PUT", path, qp, b, rt);
    }

    public <T> PveResponse<T> delete(String path, Map<String, String> qp, Object b, TypeReference<T> rt) {
        return execute("DELETE", path, qp, b, rt);
    }


    private <T> PveResponse<T> execute(String method, String relativePath, Map<String, String> queryParams,
                                       Object body, TypeReference<T> responseType) {

        // 1. 将实际的API调用逻辑封装成一个 Supplier
        Supplier<PveResponse<T>> apiCallSupplier = () ->
                executeRequest(method, relativePath, queryParams, body, responseType, true);

        // 2. 使用Resilience4j的Decorators来包裹这个Supplier
        Supplier<PveResponse<T>> resilientApiCall = Decorators.ofSupplier(apiCallSupplier)
                .withRetry(resilienceManager.getRetry())
                .withCircuitBreaker(resilienceManager.getCircuitBreaker())
                .withRateLimiter(resilienceManager.getRateLimiter())
                .decorate();

        // 3. 执行被包裹的调用，并处理可能由Resilience4j抛出的异常
        return Try.ofSupplier(resilientApiCall)
                .getOrElseThrow(this::mapResilienceException);
    }

    private RequestBody createRequestBody(Object body, String apiEndpoint) {
        if (body == null) {
            return FormBody.create(new byte[0]); // Empty body for some PVE POST/PUT
        } else if (body instanceof Map) { // Form parameters
            @SuppressWarnings("unchecked")
            Map<String, Object> params = (Map<String, Object>) body;
            FormBody.Builder formBuilder = new FormBody.Builder();
            params.forEach((key, value) -> formBuilder.add(key, String.valueOf(value)));
            return formBuilder.build();
        } else {
            try {
                return RequestBody.create(OBJECT_MAPPER.writeValueAsString(body), MediaType.parse("application/json; charset=utf-f"));
            } catch (JsonProcessingException e) {
                throw new ProxmoxApiException("Failed to serialize request body to JSON", e, clientConfig.getNodeConnectionConfig().getNodeId(), apiEndpoint);
            }
        }
    }


    private <T> PveResponse<T> executeRequest(String method, String relativePath, Map<String, String> queryParams,
                                              Object body, TypeReference<T> responseType, boolean retryOnAuthFailure) {
        NodeConnectionConfig nodeConfig = clientConfig.getNodeConnectionConfig();
        AuthenticationConfig authConfig = clientConfig.getAuthenticationConfig();
        String fullPath = nodeConfig.getApiUrl() + relativePath; // API URL already contains /api2/json

        HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse(fullPath)).newBuilder();
        if (queryParams != null) {
            queryParams.forEach(urlBuilder::addQueryParameter);
        }
        HttpUrl url = urlBuilder.build();

        ProxmoxSession session = null;
        // 对于API Token认证，不需要预先获取会话来添加Cookie或CSRF Token，因为Token本身就是认证。
        // 但对于用户名密码认证，或者即使是API Token也想通过会话管理器统一管理CSRF，则需要获取会话。
        if (authConfig.getAuthType() == AuthenticationConfig.AuthType.USERNAME_PASSWORD) { // 暂时为所有类型都获取会话，以便统一CSRF处理
            session = sessionManager.getValidSession(nodeConfig, authConfig, this.httpClient, OBJECT_MAPPER);
        }


        Request.Builder requestBuilder = new Request.Builder().url(url);
        requestBuilder.header("Accept", "application/json");

        // 添加认证和会话相关头
        if (authConfig.getAuthType() == AuthenticationConfig.AuthType.API_TOKEN) {
            requestBuilder.header("Authorization", authConfig.getApiTokenHeaderValue());
            // 对于API Token, CSRF token可能从session中来，或者PVE对某些API token的请求不严格要求
            if (session != null && session.getCsrfToken() != null && !method.equals("GET")) {
                requestBuilder.header("CSRFPreventionToken", session.getCsrfToken());
            }
        } else if (session != null) { // Username/Password auth relies on session
            if (session.getTicket() != null) {
                requestBuilder.header("Cookie", "PVEAuthCookie=" + session.getTicket());
            }
            if (!method.equals("GET") && session.getCsrfToken() != null) {
                requestBuilder.header("CSRFPreventionToken", session.getCsrfToken());
            } else if (!method.equals("GET") && session.getCsrfToken() == null) {
                LOGGER.warn("CSRF token is missing for a {} request to {} on node {} using session-based auth. This might fail.",
                        method, url, nodeConfig.getNodeId());
            }
        } else {
            // Should not happen if sessionManager.getValidSession works correctly
            throw new ProxmoxAuthException("Session is null for non-API_TOKEN authentication for node " + nodeConfig.getNodeId());
        }


        RequestBody requestBody = null;
        if (!method.equals("GET")) {
            requestBody = createRequestBody(body, relativePath);
            requestBuilder.method(method, requestBody);
        } else {
            requestBuilder.get();
        }

        Request request = requestBuilder.build();
        LOGGER.debug("Executing {} request to {} on node '{}'", method, url, nodeConfig.getNodeId());

        try (Response response = httpClient.newCall(request).execute()) {
            String responseBodyString = response.body() != null ? response.body().string() : null;
            LOGGER.trace("Response from {}: Status={}, Node='{}', Body Snippet={}",
                    url, response.code(), nodeConfig.getNodeId(),
                    (responseBodyString != null ? responseBodyString.substring(0, Math.min(responseBodyString.length(), 200)) : "null"));


            if (response.code() == 401 || response.code() == 403) { // Unauthorized or Forbidden
                // CSRF token error from PVE can also be 401 "permission denied - invalid CSRF token"
                boolean csrfError = responseBodyString != null && responseBodyString.toLowerCase().contains("csrfp");

                if (retryOnAuthFailure) {
                    LOGGER.warn("Authentication/Authorization error (Status: {}) for node '{}' at '{}'. CSRF related: {}. Invalidating session and retrying ONCE.",
                            response.code(), nodeConfig.getNodeId(), relativePath, csrfError);
                    sessionManager.invalidateSession(nodeConfig.getNodeId()); // Invalidate current session
                    return executeRequest(method, relativePath, queryParams, body, responseType, false); // Retry once, don't retry again
                } else {
                    LOGGER.error("Authentication/Authorization error (Status: {}) on retry for node '{}' at '{}'. Giving up.",
                            response.code(), nodeConfig.getNodeId(), relativePath);
                    throw new ProxmoxAuthException("Authentication/Authorization failed after retry. Status: " + response.code(), response.code());
                }
            }

            if (!response.isSuccessful()) {
                throw new ProxmoxApiException("API call failed.", response.code(), responseBodyString, nodeConfig.getNodeId(), relativePath);
            }

            // Handle empty response body for certain successful responses (e.g., 204 No Content, or some PVE ops)
            if (responseBodyString == null || responseBodyString.isEmpty() || response.code() == 204) {
                if (responseType.getType().equals(Void.class) || responseType.getType().equals(String.class) && responseBodyString == null) { // Or check specific type
                    return new PveResponse<>(null, response.headers(), response.code());
                } else if (!responseType.getType().equals(Void.class)) { // Expecting data but got none
                    LOGGER.warn("API call to {} on node '{}' succeeded with status {} but returned empty body, while expecting type {}.",
                            relativePath, nodeConfig.getNodeId(), response.code(), responseType.getType().getTypeName());
                    // Depending on strictness, this could be an error or just return null data
                    return new PveResponse<>(null, response.headers(), response.code());
                }
            }

            JsonNode rootNode = OBJECT_MAPPER.readTree(responseBodyString);
            JsonNode dataNode = rootNode.get("data");
            T data = null;

            if (dataNode != null && !dataNode.isNull()) {
                if (responseType.getType().equals(String.class) && dataNode.isTextual()) {
                    data = (T) dataNode.asText();
                } else {
                    data = OBJECT_MAPPER.convertValue(dataNode, responseType);
                }
            } else if (rootNode.isObject() && !rootNode.has("data") && (
                    responseType.getType().equals(Map.class) || responseType.getType().equals(Object.class) ||
                            // Some PVE responses are direct objects not wrapped in "data"
                            // This needs careful handling based on specific API endpoints
                            // For now, a simple check:
                            !responseType.getType().getTypeName().startsWith("java.util.List") // if not expecting a list from "data"
            )) {
                // Attempt to parse root if 'data' is missing and responseType is not a collection expected from 'data'
                try {
                    data = OBJECT_MAPPER.convertValue(rootNode, responseType);
                } catch (IllegalArgumentException e) { // If rootNode cannot be converted to T
                    LOGGER.warn("Root node parsing failed for type {} at {}, response: {}", responseType.getType().getTypeName(), relativePath, Objects.requireNonNull(responseBodyString).substring(0, Math.min(responseBodyString.length(), 500)));
                    // Fallback or throw error. If dataNode was null and root is not convertible, data remains null.
                }
            }
            // If data is still null and responseType is not Void, it means parsing failed or data was truly null
            if (data == null && !responseType.getType().equals(Void.class) && dataNode == null) {
                LOGGER.warn("Parsed data is null for non-Void type {} at {}, PVE node '{}'. Response: {}",
                        responseType.getType().getTypeName(), relativePath, nodeConfig.getNodeId(),
                        Objects.requireNonNull(responseBodyString).substring(0, Math.min(responseBodyString.length(), 500)));
            }

            return new PveResponse<>(data, response.headers(), response.code());

        } catch (Exception e) {
            if (e instanceof ProxmoxAuthException) throw (ProxmoxAuthException) e; // Re-throw auth if already specific
            if (e instanceof ProxmoxApiException) throw (ProxmoxApiException) e;   // Re-throw api if already specific
            LOGGER.error("IOException during API call to '{}' on node '{}': {}", relativePath, nodeConfig.getNodeId(), e.getMessage(), e);
            throw new ProxmoxApiException("IOException during API call: " + e.getMessage(), e, nodeConfig.getNodeId(), relativePath);
        }
    }

    // 辅助方法，用于将Resilience4j的异常转换为我们自己的客户端异常
    private ProxmoxException mapResilienceException(Throwable throwable) {
        if (throwable instanceof CallNotPermittedException) {
            return new ProxmoxApiException("CircuitBreaker is open; call not permitted.", 429, throwable.getMessage(),
                    clientConfig.getNodeConnectionConfig().getNodeId(), "N/A");
        }
        if (throwable instanceof RequestNotPermitted) {
            return new ProxmoxApiException("Rate limit exceeded; call not permitted.", 429, throwable.getMessage(),
                    clientConfig.getNodeConnectionConfig().getNodeId(), "N/A");
        }
        if (throwable instanceof ProxmoxException) {
            return (ProxmoxException) throwable;
        }
        return new ProxmoxException("An unexpected error occurred within the resilience layer.", throwable);
    }

    public static ObjectMapper getObjectMapper() {
        return OBJECT_MAPPER;
    }
}
