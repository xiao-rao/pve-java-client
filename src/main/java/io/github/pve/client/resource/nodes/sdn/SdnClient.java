package io.github.pve.client.resource.nodes.sdn;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.sdn.zones.ZonesClient;

/**
 * Client for /nodes/{node}/sdn
 * BY '@xiao-rao'
 */
public class SdnClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public SdnClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/sdn".replace("{" + "node" + "}", node);
    }

    /**
     * SDN index.
     */
    public List<Object> sdnindex() {
        PveResponse<List<Object>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `zones`
     */
    public ZonesClient zones() {
        return new ZonesClient(this.executor, this.node);
    }
}