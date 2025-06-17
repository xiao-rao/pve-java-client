package io.github.pve.client.resource.access.openid.login;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.access.openid.login.*;

/**
 * Client for /access/openid/login
 * BY '@xiao-rao'
 */
public class LoginClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public LoginClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/access/openid/login";
    }

    /**
     *  Verify OpenID authorization code and create a ticket.
     */
    public void login(LoginRequest request) {
        executor.post(this.basePath, request);
    }
}