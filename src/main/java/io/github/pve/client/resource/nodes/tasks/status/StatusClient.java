package io.github.pve.client.resource.nodes.tasks.status;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.tasks.status.*;

/**
 * Client for /nodes/{node}/tasks/{upid}/status
 * BY '@xiao-rao'
 */
public class StatusClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String upId;

    public StatusClient(ProxmoxApiExecutor executor, String node, String upId) {
        this.executor = executor;
        this.node = node;
        this.upId = upId;
        this.basePath = "/nodes/{node}/tasks/{upid}/status".replace("{" + "node" + "}", node).replace("{" + "upid" + "}", upId);
    }

    /**
     * Read task status.
     */
    public ReadTaskStatusResponse readTaskStatus() {
        PveResponse<ReadTaskStatusResponse> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}