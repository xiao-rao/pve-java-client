package io.github.pve.client.resource.access.users.token;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.access.users.token.*;

/**
 * Client for /access/users/{userid}/token
 * BY '@xiao-rao'
 */
public class TokenClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String userId;

    public TokenClient(ProxmoxApiExecutor executor, String userId) {
        this.executor = executor;
        this.userId = userId;
        this.basePath = "/access/users/{userid}/token".replace("{userid}", userId);
    }

    /**
     * Get user API tokens.
     */
    public List<TokenIndexResponse> tokenIndex() {
        PveResponse<List<TokenIndexResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Remove API token for a specific user.
     */
    public void removeToken(String tokenId) {
        executor.delete(this.basePath + "/" + tokenId);
    }

    /**
     * Get specific API token information.
     */
    public ReadTokenResponse readToken(String tokenId) {
        PveResponse<ReadTokenResponse> response = executor.get(this.basePath + "/" + tokenId, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Generate a new API token for a specific user. NOTE: returns API token value, which needs to be stored as it cannot be retrieved afterwards!
     */
    public GenerateTokenResponse generateToken(GenerateTokenRequest request) {
        PveResponse<GenerateTokenResponse> response = executor.post(this.basePath + "/" + request.getTokenId(), request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Update API token for a specific user.
     */
    public UpdateTokenInfoResponse updateTokenInfo(UpdateTokenInfoRequest request) {
        PveResponse<UpdateTokenInfoResponse> response = executor.put(this.basePath + "/" + request.getTokenId(), request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}