package io.github.pve.client.resource.nodes.vzdump;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.vzdump.defaults.DefaultsClient;
import io.github.pve.client.resource.nodes.vzdump.extractconfig.ExtractconfigClient;
// Import models if needed
import io.github.pve.client.model.nodes.vzdump.*;

/**
 * Client for /nodes/{node}/vzdump
 * BY '@xiao-rao'
 */
public class VzdumpClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public VzdumpClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/vzdump".replace("{node}", node);
    }

    /**
     * Create backup.
     */
    public String vzdump(VzdumpRequest request) {
        PveResponse<String> response = executor.post(this.basePath + "/" + request.getJobId() + "/" + request.getStorage() + "/" + request.getVmId(), request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `defaults`
     */
    public DefaultsClient defaults() {
        return new DefaultsClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `extractconfig`
     */
    public ExtractconfigClient extractconfig() {
        return new ExtractconfigClient(this.executor, this.node);
    }
}