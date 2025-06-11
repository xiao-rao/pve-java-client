package io.github.pve.client.resource.access.base;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.model.access.options.PasswordUpdateOptions;

import java.util.Map;

/**
 * 管理用户密码 - /access/password
 */
public class PasswordResourceClient {

    private final ProxmoxApiExecutor executor;

    public PasswordResourceClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
    }

    public void update(PasswordUpdateOptions options) {
        String path = "/access/password";
        Map<String, Object> params = ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {
        });
        executor.put(path, null, params, new TypeReference<Void>() {
        });
    }
}

