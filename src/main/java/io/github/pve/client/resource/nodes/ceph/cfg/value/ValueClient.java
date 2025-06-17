package io.github.pve.client.resource.nodes.ceph.cfg.value;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/ceph/cfg/value
 * BY '@xiao-rao'
 */
public class ValueClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public ValueClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/ceph/cfg/value".replace("{" + "node" + "}", node);
    }

    /**
     * Get configured values from either the config file or config DB.
     */
    public Map<String, Object> value(String configKeys) {
        Map<String, Object> queryParams = new HashMap<>();
        if (configKeys != null) {
            queryParams.put("config-keys", configKeys);
        }
        PveResponse<Map<String, Object>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}