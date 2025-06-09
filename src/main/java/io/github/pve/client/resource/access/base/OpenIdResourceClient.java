package io.github.pve.client.resource.access.base;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import io.github.pve.client.model.access.options.OpenIdLoginOptions;
import io.github.pve.client.resource.BaseResourceClient;

import java.util.HashMap;
import java.util.Map;

/**
 * 管理 OpenID Connect 提供者 - /access/openid
 * 注意: OIDC的管理在PVE中通常与 /access/domains 共享相同的模型和逻辑,
 * 但API路径不同。这里我们为了API的清晰性单独实现。
 */
public class OpenIdResourceClient extends BaseResourceClient {

    public OpenIdResourceClient(ProxmoxApiExecutor executor) {
        super(executor);
    }


    public Map<String, String> getAuthUrl(String realm, String redirectUri) throws Exception {
        String path = "/access/openid/" + realm + "/auth-url";
        Map<String, String> params = new HashMap<>();
        params.put("redirect-uri", redirectUri);
        PveResponse<Map<String, String>> r = executor.get(path, params, new TypeReference<>() {
        });
        return r.getData().orElseThrow(() -> new Exception("Get OIDC Auth URL data is null"));
    }

    public Map<String, String> login(String realm, OpenIdLoginOptions options) throws Exception {
        String path = "/access/openid/" + realm + "/login";
        Map<String, Object> params = ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {
        });
        PveResponse<Map<String, String>> r = executor.post(path, null, params, new TypeReference<>() {
        });
        return r.getData().orElseThrow(() -> new Exception("OIDC login failed"));
    }
}
