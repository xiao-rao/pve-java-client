package io.github.pve.client.resource.nodes.lxc.mtunnelwebsocket;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.lxc.mtunnelwebsocket.*;

/**
 * Client for /nodes/{node}/lxc/{vmid}/mtunnelwebsocket
 * BY '@xiao-rao'
 */
public class MtunnelwebsocketClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public MtunnelwebsocketClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/lxc/{vmid}/mtunnelwebsocket".replace("{node}", node).replace("{vmid}", vmId);
    }

    /**
     * Migration tunnel endpoint for websocket upgrade - only for internal use by VM migration.
     */
    public MtunnelwebsocketResponse mtunnelwebsocket(String socket, String ticket) {
        Map<String, Object> queryParams = new HashMap<>();
        if (socket != null) {
            queryParams.put("socket", socket);
        }
        if (ticket != null) {
            queryParams.put("ticket", ticket);
        }
        PveResponse<MtunnelwebsocketResponse> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}