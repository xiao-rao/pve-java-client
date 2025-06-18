package io.github.pve.client.resource.nodes.services.start;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/services/{service}/start
 * BY '@xiao-rao'
 */
public class StartClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String service;

    public StartClient(ProxmoxApiExecutor executor, String node, String service) {
        this.executor = executor;
        this.node = node;
        this.service = service;
        this.basePath = "/nodes/{node}/services/{service}/start".replace("{" + "node" + "}", node).replace("{" + "service" + "}", service);
    }

    /**
     * Start service.
     */
    public String serviceStart() {
        PveResponse<String> response = executor.post(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}