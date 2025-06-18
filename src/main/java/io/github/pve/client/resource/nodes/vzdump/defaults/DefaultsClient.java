package io.github.pve.client.resource.nodes.vzdump.defaults;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.vzdump.defaults.*;

/**
 * Client for /nodes/{node}/vzdump/defaults
 * BY '@xiao-rao'
 */
public class DefaultsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public DefaultsClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/vzdump/defaults".replace("{" + "node" + "}", node);
    }

    /**
     * Get the currently configured vzdump defaults.
     */
    public DefaultsResponse defaults(String storage) {
        PveResponse<DefaultsResponse> response = executor.get(this.basePath + "/" + storage, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}