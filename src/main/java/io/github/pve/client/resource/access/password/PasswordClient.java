package io.github.pve.client.resource.access.password;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.access.password.*;

/**
 * Client for /access/password
 * BY '@xiao-rao'
 */
public class PasswordClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public PasswordClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/access/password";
    }

    /**
     * Change user password.
     */
    public void changePassword(ChangePasswordRequest request) {
        executor.put(this.basePath, request);
    }
}