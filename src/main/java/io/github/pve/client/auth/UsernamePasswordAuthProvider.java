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
 * 基于用户名和密码的认证提供者
 */
public class UsernamePasswordAuthProvider implements AuthenticationProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsernamePasswordAuthProvider.class);

    @Override
    public AuthenticationDetails authenticate(NodeConnectionConfig nodeConnectionConfig,
                                              AuthenticationConfig authConfig,
                                              OkHttpClient httpClient,
                                              ObjectMapper objectMapper) throws ProxmoxAuthException {
        if (authConfig.getAuthType() != AuthenticationConfig.AuthType.USERNAME_PASSWORD) {
            throw new ProxmoxAuthException("UsernamePasswordAuthProvider cannot handle auth type: " + authConfig.getAuthType());
        }

        String loginUrl = nodeConnectionConfig.apiUrl() + "/access/ticket";
        LOGGER.debug("Attempting username/password login to {} for user {} @ realm {}",
                loginUrl, authConfig.getUsername(), authConfig.getRealm());

        Map<String, String> formParams = new HashMap<>();
        formParams.put("username", authConfig.getUsername());
        formParams.put("password", authConfig.getPassword());
        formParams.put("realm", authConfig.getRealm());

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
                LOGGER.error("Login failed for user '{}' to PVE node '{}'. Status: {}, Response: {}",
                        authConfig.getUsername(), nodeConnectionConfig.nodeId(), response.code(), responseBodyString);
                throw new ProxmoxAuthException("Login failed. Status: " + response.code() + ", Response: " + responseBodyString, response.code());
            }

            JsonNode rootNode = objectMapper.readTree(responseBodyString);
            JsonNode dataNode = rootNode.get("data");

            if (dataNode == null || !dataNode.isObject()) {
                LOGGER.error("Invalid login response structure from PVE node '{}': 'data' field missing or not an object. Response: {}",
                        nodeConnectionConfig.nodeId(), responseBodyString);
                throw new ProxmoxAuthException("Invalid login response structure: 'data' field missing or not an object.");
            }

            String csrfToken = dataNode.has("CSRFPreventionToken") ? dataNode.get("CSRFPreventionToken").asText() : null;
            String ticket = dataNode.has("ticket") ? dataNode.get("ticket").asText() : null; // This is the PVEAuthCookie value
            String authenticatedUsername = dataNode.has("username") ? dataNode.get("username").asText() : authConfig.getUsername(); // Usually in format user@realm

            if (csrfToken == null || csrfToken.isEmpty()) {
                LOGGER.error("CSRFPreventionToken not found in login response from PVE node '{}'. Response: {}",
                        nodeConnectionConfig.nodeId(), responseBodyString);
                throw new ProxmoxAuthException("CSRFPreventionToken not found in login response.");
            }
            if (ticket == null || ticket.isEmpty()) {
                LOGGER.warn("Ticket (PVEAuthCookie) not found in login response from PVE node '{}'. Session tracking might be impaired. Response: {}",
                        nodeConnectionConfig.nodeId(), responseBodyString);
                // Depending on strictness, this could be an error.
            }


            LOGGER.info("Successfully authenticated user '{}' with PVE node '{}'.", authenticatedUsername, nodeConnectionConfig.nodeId());
            return new AuthenticationDetails(ticket, csrfToken, authenticatedUsername);

        } catch (IOException e) {
            LOGGER.error("IOException during login attempt for user '{}' to PVE node '{}': {}",
                    authConfig.getUsername(), nodeConnectionConfig.nodeId(), e.getMessage(), e);
            throw new ProxmoxAuthException("IOException during login: " + e.getMessage(), e);
        }
    }
}
