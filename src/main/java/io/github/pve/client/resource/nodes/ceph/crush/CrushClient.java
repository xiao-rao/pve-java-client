package io.github.pve.client.resource.nodes.ceph.crush;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/ceph/crush
 * BY '@xiao-rao'
 */
public class CrushClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public CrushClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/ceph/crush".replace("{" + "node" + "}", node);
    }

    /**
     * Get OSD crush map
     */
    public String crush() {
        PveResponse<String> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}