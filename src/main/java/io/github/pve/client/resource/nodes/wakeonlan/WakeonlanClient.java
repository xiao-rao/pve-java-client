package io.github.pve.client.resource.nodes.wakeonlan;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/wakeonlan
 * BY '@xiao-rao'
 */
public class WakeonlanClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public WakeonlanClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/wakeonlan".replace("{" + "node" + "}", node);
    }

    /**
     * Try to wake a node via 'wake on LAN' network packet.
     */
    public String wakeonlan() {
        PveResponse<String> response = executor.post(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}