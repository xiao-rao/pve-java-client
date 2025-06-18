package io.github.pve.client.resource.nodes.qemu.status.start;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.qemu.status.start.*;

/**
 * Client for /nodes/{node}/qemu/{vmid}/status/start
 * BY '@xiao-rao'
 */
public class StartClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public StartClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/qemu/{vmid}/status/start".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmId);
    }

    /**
     * Start virtual machine.
     */
    public String vmStart(VmStartRequest request) {
        PveResponse<String> response = executor.post(this.basePath, request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}