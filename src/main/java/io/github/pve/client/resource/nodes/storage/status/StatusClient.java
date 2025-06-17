package io.github.pve.client.resource.nodes.storage.status;

import java.util.Map;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/storage/{storage}/status
 * BY '@xiao-rao'
 */
public class StatusClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String storage;

    public StatusClient(ProxmoxApiExecutor executor, String node, String storage) {
        this.executor = executor;
        this.node = node;
        this.storage = storage;
        this.basePath = "/nodes/{node}/storage/{storage}/status".replace("{" + "node" + "}", node).replace("{" + "storage" + "}", storage);
    }

    /**
     * Read storage status.
     */
    public Map<String, Object> readStatus() {
        PveResponse<Map<String, Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}