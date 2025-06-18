package io.github.pve.client.resource.nodes.qemu.vncproxy;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/qemu/{vmid}/vncproxy
 * BY '@xiao-rao'
 */
public class VncproxyClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public VncproxyClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/qemu/{vmid}/vncproxy".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmId);
    }

    /**
     * Creates a TCP VNC proxy connections.
     */
    public void vncproxy(Boolean generatePassword, Boolean websocket) {
        Map<String, Object> options = new HashMap<>();
        if (generatePassword != null) {
            options.put("generate-password", generatePassword);
        }
        if (websocket != null) {
            options.put("websocket", websocket);
        }
        executor.post(this.basePath, options);
    }
}