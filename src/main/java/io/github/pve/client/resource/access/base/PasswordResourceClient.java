package io.github.pve.client.resource.access.base;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.exception.ProxmoxApiException;
import io.github.pve.client.exception.ProxmoxAuthException;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.model.access.options.PasswordUpdateOptions;
import io.github.pve.client.resource.BaseResourceClient;

import java.util.Map;

/**
 * 管理用户密码 - /access/password
 */
public class PasswordResourceClient extends BaseResourceClient {

    public PasswordResourceClient(ProxmoxApiExecutor executor) {
        super(executor);
    }

    public void update(PasswordUpdateOptions options) throws ProxmoxApiException, ProxmoxAuthException {
        String path = "/access/password";
        Map<String, Object> params = ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {});
        executor.put(path, null, params, new TypeReference<Void>() {});
    }
}

