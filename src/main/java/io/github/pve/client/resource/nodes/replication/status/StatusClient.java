package io.github.pve.client.resource.nodes.replication.status;

import java.util.Map;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/replication/{id}/status
 * BY '@xiao-rao'
 */
public class StatusClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String id;

    public StatusClient(ProxmoxApiExecutor executor, String node, String id) {
        this.executor = executor;
        this.node = node;
        this.id = id;
        this.basePath = "/nodes/{node}/replication/{id}/status".replace("{" + "node" + "}", node).replace("{" + "id" + "}", id);
    }

    /**
     * Get replication job status.
     */
    public Map<String, Object> jobStatus() {
        PveResponse<Map<String, Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}