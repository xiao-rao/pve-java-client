package io.github.pve.client.resource.nodes.vncshell;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.vncshell.*;

/**
 * Client for /nodes/{node}/vncshell
 * BY '@xiao-rao'
 */
public class VncshellClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public VncshellClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/vncshell".replace("{node}", node);
    }

    /**
     * Creates a VNC Shell proxy.
     */
    public void vncshell(VncshellRequest request) {
        executor.post(this.basePath, request);
    }
}