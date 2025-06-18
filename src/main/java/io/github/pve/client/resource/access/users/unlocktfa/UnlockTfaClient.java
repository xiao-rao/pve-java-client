package io.github.pve.client.resource.access.users.unlocktfa;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /access/users/{userid}/unlock-tfa
 * BY '@xiao-rao'
 */
public class UnlockTfaClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String userId;

    public UnlockTfaClient(ProxmoxApiExecutor executor, String userId) {
        this.executor = executor;
        this.userId = userId;
        this.basePath = "/access/users/{userid}/unlock-tfa".replace("{" + "userid" + "}", userId);
    }

    /**
     * Unlock a user's TFA authentication.
     */
    public Boolean unlockTfa() {
        PveResponse<Boolean> response = executor.put(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}