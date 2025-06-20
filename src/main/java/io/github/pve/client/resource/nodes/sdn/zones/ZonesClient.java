package io.github.pve.client.resource.nodes.sdn.zones;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.sdn.zones.content.ContentClient;
// Import models if needed
import io.github.pve.client.model.nodes.sdn.zones.*;

/**
 * Client for /nodes/{node}/sdn/zones
 * BY '@xiao-rao'
 */
public class ZonesClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public ZonesClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/sdn/zones".replace("{node}", node);
    }

    /**
     * Get status for all zones.
     */
    public List<SdnZonesIndexResponse> index() {
        PveResponse<List<SdnZonesIndexResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * 
     */
    public List<DiridxResponse> diridx(String zone) {
        PveResponse<List<DiridxResponse>> response = executor.get(this.basePath + "/" + zone, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Client for the specific `zone` resource.
     * @param zone The path parameter `zone`.
     */
    public ContentClient content(String zone) {
        return new ContentClient(this.executor, this.node, zone);
    }
}