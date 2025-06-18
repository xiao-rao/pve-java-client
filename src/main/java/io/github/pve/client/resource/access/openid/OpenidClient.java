package io.github.pve.client.resource.access.openid;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.access.openid.authurl.AuthUrlClient;
import io.github.pve.client.resource.access.openid.login.LoginClient;
// Import models if needed
import io.github.pve.client.model.access.openid.*;

/**
 * Client for /access/openid
 * BY '@xiao-rao'
 */
public class OpenidClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public OpenidClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/access/openid";
    }

    /**
     * Directory index.
     */
    public List<AccessOpenidIndexResponse> index() {
        PveResponse<List<AccessOpenidIndexResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `authUrl`
     */
    public AuthUrlClient authUrl() {
        return new AuthUrlClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `login`
     */
    public LoginClient login() {
        return new LoginClient(this.executor);
    }
}