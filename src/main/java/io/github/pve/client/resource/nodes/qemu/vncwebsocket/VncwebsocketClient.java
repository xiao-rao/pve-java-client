package io.github.pve.client.resource.nodes.qemu.vncwebsocket;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.qemu.vncwebsocket.*;

/**
 * Client for /nodes/{node}/qemu/{vmid}/vncwebsocket
 * BY '@xiao-rao'
 */
public class VncwebsocketClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public VncwebsocketClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/qemu/{vmid}/vncwebsocket".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmId);
    }

    /**
     * Opens a weksocket for VNC traffic.
     */
    public VncwebsocketResponse vncwebsocket(Integer port, String vncticket) {
        Map<String, Object> queryParams = new HashMap<>();
        if (port != null) {
            queryParams.put("port", port);
        }
        if (vncticket != null) {
            queryParams.put("vncticket", vncticket);
        }
        PveResponse<VncwebsocketResponse> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}