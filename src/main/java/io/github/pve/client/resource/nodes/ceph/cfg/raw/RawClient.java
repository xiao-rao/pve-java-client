package io.github.pve.client.resource.nodes.ceph.cfg.raw;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/ceph/cfg/raw
 * BY '@xiao-rao'
 */
public class RawClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public RawClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/ceph/cfg/raw".replace("{" + "node" + "}", node);
    }

    /**
     * Get the Ceph configuration file.
     */
    public String raw() {
        PveResponse<String> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}