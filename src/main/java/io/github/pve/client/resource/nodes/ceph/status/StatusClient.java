package io.github.pve.client.resource.nodes.ceph.status;

import java.util.Map;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/ceph/status
 * BY '@xiao-rao'
 */
public class StatusClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public StatusClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/ceph/status".replace("{" + "node" + "}", node);
    }

    /**
     * Get ceph status.
     */
    public Map<String, Object> status() {
        PveResponse<Map<String, Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}