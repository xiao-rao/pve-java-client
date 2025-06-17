package io.github.pve.client.resource.cluster.metrics.server;

import java.util.List;
import java.util.Map;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.metrics.server.*;

/**
 * Client for /cluster/metrics/server
 * BY '@xiao-rao'
 */
public class ServerClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public ServerClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/metrics/server";
    }

    /**
     * List configured metric servers.
     */
    public ServerIndexResponse serverIndex() {
        PveResponse<ServerIndexResponse> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Remove Metric server.
     */
    public void delete(String id) {
        executor.delete(this.basePath + "/" + id);
    }

    /**
     * Read metric server configuration.
     */
    public void read(String id) {
        executor.get(this.basePath + "/" + id);
    }

    /**
     * Create a new external metric server config
     */
    public void create(CreateRequest request) {
        executor.post(this.basePath + "/" + request.getId(), request);
    }

    /**
     * Update metric server configuration.
     */
    public void update(UpdateRequest request) {
        executor.put(this.basePath + "/" + request.getId(), request);
    }
}