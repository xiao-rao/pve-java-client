package io.github.pve.client.resource.access.users;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.access.users.tfa.TfaClient;
import io.github.pve.client.resource.access.users.unlocktfa.UnlockTfaClient;
import io.github.pve.client.resource.access.users.token.TokenClient;
// Import models if needed
import io.github.pve.client.model.access.users.*;

/**
 * Client for /access/users
 * BY '@xiao-rao'
 */
public class UsersClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public UsersClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/access/users";
    }

    /**
     * User index.
     */
    public IndexResponse index(Boolean enabled, Boolean full) {
        Map<String, Object> queryParams = new HashMap<>();
        if (enabled != null) {
            queryParams.put("enabled", enabled);
        }
        if (full != null) {
            queryParams.put("full", full);
        }
        PveResponse<IndexResponse> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create new user.
     */
    public void createUser(CreateUserRequest request) {
        executor.post(this.basePath, request);
    }

    /**
     * Delete user.
     */
    public void deleteUser(String userid) {
        executor.delete(this.basePath + "/" + userid);
    }

    /**
     * Get user configuration.
     */
    public ReadUserResponse readUser(String userid) {
        PveResponse<ReadUserResponse> response = executor.get(this.basePath + "/" + userid, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Update user configuration.
     */
    public void updateUser(UpdateUserRequest request) {
        executor.put(this.basePath + "/" + request.getUserid(), request);
    }

    /**
     * Client for the specific `userid` resource.
     * @param userid The path parameter `userid`.
     */
    public TfaClient tfa(String userid) {
        return new TfaClient(this.executor, userid);
    }

    /**
     * Client for the specific `userid` resource.
     * @param userid The path parameter `userid`.
     */
    public UnlockTfaClient unlockTfa(String userid) {
        return new UnlockTfaClient(this.executor, userid);
    }

    /**
     * Client for the specific `userid` resource.
     * @param userid The path parameter `userid`.
     */
    public TokenClient token(String userid) {
        return new TokenClient(this.executor, userid);
    }
}