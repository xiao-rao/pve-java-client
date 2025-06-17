package io.github.pve.client.resource.nodes.certificates.info;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.certificates.info.*;

/**
 * Client for /nodes/{node}/certificates/info
 * BY '@xiao-rao'
 */
public class InfoClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public InfoClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/certificates/info".replace("{" + "node" + "}", node);
    }

    /**
     * Get information about node's certificates.
     */
    public InfoResponse info() {
        PveResponse<InfoResponse> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}