package io.github.pve.client.resource.nodes.services.state;

import java.util.Map;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/services/{service}/state
 * BY '@xiao-rao'
 */
public class StateClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String service;

    public StateClient(ProxmoxApiExecutor executor, String node, String service) {
        this.executor = executor;
        this.node = node;
        this.service = service;
        this.basePath = "/nodes/{node}/services/{service}/state".replace("{node}", node).replace("{service}", service);
    }

    /**
     * Read service properties
     */
    public Map<String, Object> serviceState() {
        PveResponse<Map<String, Object>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}