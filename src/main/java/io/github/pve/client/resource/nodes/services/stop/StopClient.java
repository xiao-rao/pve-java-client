package io.github.pve.client.resource.nodes.services.stop;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/services/{service}/stop
 * BY '@xiao-rao'
 */
public class StopClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String service;

    public StopClient(ProxmoxApiExecutor executor, String node, String service) {
        this.executor = executor;
        this.node = node;
        this.service = service;
        this.basePath = "/nodes/{node}/services/{service}/stop".replace("{node}", node).replace("{service}", service);
    }

    /**
     * Stop service.
     */
    public String serviceStop() {
        PveResponse<String> response = executor.post(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}