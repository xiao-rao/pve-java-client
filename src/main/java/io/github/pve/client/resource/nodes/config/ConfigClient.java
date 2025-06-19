package io.github.pve.client.resource.nodes.config;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.config.*;

/**
 * Client for /nodes/{node}/config
 * BY '@xiao-rao'
 */
public class ConfigClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public ConfigClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/config".replace("{node}", node);
    }

    /**
     * Get node configuration options.
     */
    public GetConfigResponse getConfig(String property) {
        Map<String, Object> queryParams = new HashMap<>();
        if (property != null) {
            queryParams.put("property", property);
        }
        PveResponse<GetConfigResponse> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Set node configuration options.
     */
    public void setOptions(SetOptionsRequest request) {
        executor.put(this.basePath, request);
    }
}