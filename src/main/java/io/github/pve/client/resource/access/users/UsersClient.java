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
    public List<AccessUsersIndexResponse> index(Boolean enabled, Boolean full) {
        Map<String, Object> queryParams = new HashMap<>();
        if (enabled != null) {
            queryParams.put("enabled", enabled);
        }
        if (full != null) {
            queryParams.put("full", full);
        }
        PveResponse<List<AccessUsersIndexResponse>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
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
    public void deleteUser(String userId) {
        executor.delete(this.basePath + "/" + userId);
    }

    /**
     * Get user configuration.
     */
    public ReadUserResponse readUser(String userId) {
        PveResponse<ReadUserResponse> response = executor.get(this.basePath + "/" + userId, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Update user configuration.
     */
    public void updateUser(UpdateUserRequest request) {
        executor.put(this.basePath + "/" + request.getUserId(), request);
    }

    /**
     * Client for the specific `userId` resource.
     * @param userId The path parameter `userId`.
     */
    public TfaClient tfa(String userId) {
        return new TfaClient(this.executor, userId);
    }

    /**
     * Client for the specific `userId` resource.
     * @param userId The path parameter `userId`.
     */
    public UnlockTfaClient unlockTfa(String userId) {
        return new UnlockTfaClient(this.executor, userId);
    }

    /**
     * Client for the specific `userId` resource.
     * @param userId The path parameter `userId`.
     */
    public TokenClient token(String userId) {
        return new TokenClient(this.executor, userId);
    }
}