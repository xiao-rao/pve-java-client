package io.github.pve.client.resource.nodes.lxc.vncproxy;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.lxc.vncproxy.*;

/**
 * Client for /nodes/{node}/lxc/{vmid}/vncproxy
 * BY '@xiao-rao'
 */
public class VncproxyClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public VncproxyClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/lxc/{vmid}/vncproxy".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Creates a TCP VNC proxy connections.
     */
    public void vncproxy(VncproxyRequest request) {
        executor.post(this.basePath, request);
    }
}