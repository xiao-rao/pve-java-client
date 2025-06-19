package io.github.pve.client.resource.nodes.spiceshell;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.spiceshell.*;

/**
 * Client for /nodes/{node}/spiceshell
 * BY '@xiao-rao'
 */
public class SpiceshellClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public SpiceshellClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/spiceshell".replace("{node}", node);
    }

    /**
     * Creates a SPICE shell.
     */
    public void spiceshell(SpiceshellRequest request) {
        executor.post(this.basePath, request);
    }
}