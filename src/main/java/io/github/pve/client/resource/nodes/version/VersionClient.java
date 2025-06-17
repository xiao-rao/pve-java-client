package io.github.pve.client.resource.nodes.version;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

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
    public Object version() {
        PveResponse<Object> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}