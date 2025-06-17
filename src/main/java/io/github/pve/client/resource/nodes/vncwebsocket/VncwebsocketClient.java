package io.github.pve.client.resource.nodes.vncwebsocket;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/vncwebsocket
 * BY '@xiao-rao'
 */
public class VncwebsocketClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public VncwebsocketClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/vncwebsocket".replace("{" + "node" + "}", node);
    }

    /**
     * Opens a websocket for VNC traffic.
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