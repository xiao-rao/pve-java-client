package io.github.pve.client.resource.nodes.services.reload;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/services/{service}/reload
 * BY '@xiao-rao'
 */
public class ReloadClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String service;

    public ReloadClient(ProxmoxApiExecutor executor, String node, String service) {
        this.executor = executor;
        this.node = node;
        this.service = service;
        this.basePath = "/nodes/{node}/services/{service}/reload".replace("{" + "node" + "}", node).replace("{" + "service" + "}", service);
    }

    /**
     * Reload service. Falls back to restart if service cannot be reloaded.
     */
    public String serviceReload() {
        PveResponse<String> response = executor.post(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}