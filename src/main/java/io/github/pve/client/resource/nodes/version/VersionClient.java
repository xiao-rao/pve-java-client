package io.github.pve.client.resource.nodes.version;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.version.*;

/**
 * Client for /nodes/{node}/version
 * BY '@xiao-rao'
 */
public class VersionClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public VersionClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/version".replace("{" + "node" + "}", node);
    }

    /**
     * API version details
     */
    public VersionResponse version() {
        PveResponse<VersionResponse> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}