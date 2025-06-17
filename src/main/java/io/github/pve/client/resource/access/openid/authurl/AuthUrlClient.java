package io.github.pve.client.resource.access.openid.authurl;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /access/openid/auth-url
 * BY '@xiao-rao'
 */
public class AuthUrlClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public AuthUrlClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/access/openid/auth-url";
    }

    /**
     * Get the OpenId Authorization Url for the specified realm.
     */
    public String authUrl(String realm, String redirectUrl) {
        Map<String, Object> options = new HashMap<>();
        if (realm != null) {
            options.put("realm", realm);
        }
        if (redirectUrl != null) {
            options.put("redirect-url", redirectUrl);
        }
        PveResponse<String> response = executor.post(this.basePath, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}