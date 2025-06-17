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
    protected final String userid;

    public TokenClient(ProxmoxApiExecutor executor, String userid) {
        this.executor = executor;
        this.userid = userid;
        this.basePath = "/access/users/{userid}/token".replace("{" + "userid" + "}", userid);
    }

    /**
     * Get user API tokens.
     */
    public TokenIndexResponse tokenIndex() {
        PveResponse<TokenIndexResponse> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Remove API token for a specific user.
     */
    public void removeToken(String tokenid) {
        executor.delete(this.basePath + "/" + tokenid);
    }

    /**
     * Get specific API token information.
     */
    public void readToken(String tokenid) {
        executor.get(this.basePath + "/" + tokenid);
    }

    /**
     * Generate a new API token for a specific user. NOTE: returns API token value, which needs to be stored as it cannot be retrieved afterwards!
     */
    public void generateToken(GenerateTokenRequest request) {
        executor.post(this.basePath + "/" + request.getTokenid(), request);
    }

    /**
     * Update API token for a specific user.
     */
    public void updateTokenInfo(UpdateTokenInfoRequest request) {
        executor.put(this.basePath + "/" + request.getTokenid(), request);
    }
}