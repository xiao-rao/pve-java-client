package io.github.pve.client.resource.nodes.stopall;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.stopall.*;

/**
 * Client for /nodes/{node}/stopall
 * BY '@xiao-rao'
 */
public class StopallClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public StopallClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/stopall".replace("{" + "node" + "}", node);
    }

    /**
     * Stop all VMs and Containers.
     */
    public String stopall(StopallRequest request) {
        PveResponse<String> response = executor.post(this.basePath, request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}