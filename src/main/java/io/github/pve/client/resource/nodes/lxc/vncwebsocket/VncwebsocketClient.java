package io.github.pve.client.resource.nodes.lxc.vncwebsocket;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/lxc/{vmid}/vncwebsocket
 * BY '@xiao-rao'
 */
public class VncwebsocketClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public VncwebsocketClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/lxc/{vmid}/vncwebsocket".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Opens a weksocket for VNC traffic.
     */
    public Object vncwebsocket(Integer port, String vncticket) {
        Map<String, Object> queryParams = new HashMap<>();
        if (port != null) {
            queryParams.put("port", port);
        }
        if (vncticket != null) {
            queryParams.put("vncticket", vncticket);
        }
        PveResponse<Object> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}