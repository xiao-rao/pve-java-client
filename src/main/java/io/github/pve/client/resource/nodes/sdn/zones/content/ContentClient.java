package io.github.pve.client.resource.nodes.sdn.zones.content;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/sdn/zones/{zone}/content
 * BY '@xiao-rao'
 */
public class ContentClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String zone;

    public ContentClient(ProxmoxApiExecutor executor, String node, String zone) {
        this.executor = executor;
        this.node = node;
        this.zone = zone;
        this.basePath = "/nodes/{node}/sdn/zones/{zone}/content".replace("{" + "node" + "}", node).replace("{" + "zone" + "}", zone);
    }

    /**
     * List zone content.
     */
    public List<Object> index() {
        PveResponse<List<Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}