package io.github.pve.client.auth;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.pve.client.config.AuthenticationConfig;
import io.github.pve.client.config.NodeConnectionConfig;
import io.github.pve.client.exception.ProxmoxAuthException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * 基于API Token的认证提供者
 * 对于API Token，认证步骤主要是验证Token是否有效，并获取一个CSRF Token（如果需要）。
 * Proxmox API Token本身包含了认证信息，可以直接用于请求。
 * 但为了统一会话管理，我们仍然可以尝试通过 /access/ticket 获取一个 CSRF Token。
 * 如果 /access/ticket 不接受API Token作为凭据（通常它期望用户名/密码），
 * 那么使用API Token时，CSRF Token可能需要从其他途径获取，或者某些操作不需要它。
 * Proxmox的文档说明 API Token 可以直接使用，但CSRF Token对写操作仍然重要。
 * <p>
 * 更新：PVE API Token可以直接使用，并且通常不需要单独调用 /access/ticket 来获取CSRF。
 * CSRF token 可以从使用API Token的第一个成功的GET请求的响应头中获取（如果PVE返回了），
 * 或者对于某些PVE版本/配置，写操作时会自动处理或不需要。
 * <p>
 * 为简化并与用户名/密码登录流程保持一致，这里尝试通过API Token "登录" /access/ticket。
 * 如果PVE的 /access/ticket 端点支持使用 API Token ID 作为用户名，API Token Secret 作为密码进行调用，
 * 那么可以复用类似的逻辑获取CSRF Token。否则，此认证提供者可能只需要验证Token格式。
 * <p>
 * 查阅PVE文档，API Token的使用方式是在Header中直接提供 `Authorization: PVEAPIToken <tokenid>=<secret>`。
 * CSRFPreventionToken 仍然是对写操作（POST/PUT/DELETE）推荐的。
 * 一种获取方式是，使用API Token进行一次GET请求（例如 GET /version），
 * PVE的响应中（如果配置正确）可能会包含Set-Cookie头，进而包含CSRF token。
 * 或者，更可靠的方式是像Username/Password那样，POST到/access/ticket，
 * 提供`username`=`user@realm!tokenId`和`password`=`secretUUID`。
 */
public class ApiTokenAuthProvider implements AuthenticationProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiTokenAuthProvider.class);

    @Override
    public AuthenticationDetails authenticate(NodeConnectionConfig nodeConnectionConfig,
                                              AuthenticationConfig authConfig,
                                              OkHttpClient httpClient,
                                              ObjectMapper objectMapper) throws ProxmoxAuthException {
        if (authConfig.getAuthType() != AuthenticationConfig.AuthType.API_TOKEN) {
            throw new ProxmoxAuthException("ApiTokenAuthProvider cannot handle auth type: " + authConfig.getAuthType());
        }

        // API Token 认证的核心是 PVEAPIToken header。
        // 为了获取 CSRF token 和一个 "ticket" (PVEAuthCookie) 以便统一会话管理，
        // 我们尝试像用户名/密码登录一样 POST 到 /access/ticket。
        // Proxmox API允许使用 Token ID 作为 username，Token Secret 作为 password。
        String loginUrl = nodeConnectionConfig.apiUrl() + "/access/ticket";
        String apiTokenId = authConfig.getUsername(); // This is user@realm!tokenId
        String apiTokenSecret = authConfig.getPassword(); // This is the UUID secret

        LOGGER.debug("Attempting API Token authentication (via /access/ticket) to {} for token ID '{}'",
                loginUrl, apiTokenId.split("!")[0] + "!***");


        Map<String, String> formParams = new HashMap<>();
        formParams.put("username", apiTokenId);
        formParams.put("password", apiTokenSecret);
        // Realm is part of the apiTokenId, not needed as a separate param here for PVE.

        okhttp3.FormBody.Builder formBodyBuilder = new okhttp3.FormBody.Builder();
        formParams.forEach(formBodyBuilder::add);
        RequestBody requestBody = formBodyBuilder.build();

        Request request = new Request.Builder()
                .url(loginUrl)
                .post(requestBody)
                .header("Accept", "application/json")
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            String responseBodyString = response.body() != null ? response.body().string() : "";

            if (!response.isSuccessful()) {
                // API Token本身可能有效，但无法通过/access/ticket获取CSRF，这可能是个问题。
                // 或者API Token无效。
                LOGGER.error("API Token authentication via /access/ticket failed for token ID '{}' on PVE node '{}'. Status: {}, Response: {}",
                        apiTokenId.split("!")[0] + "!***", nodeConnectionConfig.nodeId(), response.code(), responseBodyString);
                throw new ProxmoxAuthException(
                        String.format("API Token authentication via /access/ticket failed. Status: %d. This might indicate an invalid API token or a PVE configuration issue.", response.code()),
                        response.code()
                );
            }

            JsonNode rootNode = objectMapper.readTree(responseBodyString);
            JsonNode dataNode = rootNode.get("data");

            if (dataNode == null || !dataNode.isObject()) {
                LOGGER.error("Invalid response structure from /access/ticket using API token for PVE node '{}'. Response: {}",
                        nodeConnectionConfig.nodeId(), responseBodyString);
                throw new ProxmoxAuthException("Invalid response structure from /access/ticket: 'data' field missing or not an object.");
            }

            String csrfToken = dataNode.has("CSRFPreventionToken") ? dataNode.get("CSRFPreventionToken").asText() : null;
            String ticket = dataNode.has("ticket") ? dataNode.get("ticket").asText() : null;
            String authenticatedUsername = dataNode.has("username") ? dataNode.get("username").asText() : apiTokenId;


            if (csrfToken == null || csrfToken.isEmpty()) {
                LOGGER.error("CSRFPreventionToken not found in /access/ticket response using API Token for PVE node '{}'. Response: {}",
                        nodeConnectionConfig.nodeId(), responseBodyString);
                throw new ProxmoxAuthException("CSRFPreventionToken not found in /access/ticket response when using API Token.");
            }
            // Ticket might still be useful for consistent session handling, even if API token is the primary auth.
            if (ticket == null || ticket.isEmpty()) {
                LOGGER.warn("Ticket (PVEAuthCookie) not found in /access/ticket response using API Token for PVE node '{}'.",
                        nodeConnectionConfig.nodeId());
            }

            LOGGER.info("Successfully obtained session details (CSRF, ticket) using API Token ID '{}' with PVE node '{}'.",
                    authenticatedUsername.split("!")[0] + "!***", nodeConnectionConfig.nodeId());
            return new AuthenticationDetails(ticket, csrfToken, authenticatedUsername);

        } catch (IOException e) {
            LOGGER.error("IOException during API Token authentication via /access/ticket for token ID '{}' on PVE node '{}': {}",
                    apiTokenId.split("!")[0] + "!***", nodeConnectionConfig.nodeId(), e.getMessage(), e);
            throw new ProxmoxAuthException("IOException during API Token authentication via /access/ticket: " + e.getMessage(), e);
        }
    }
}