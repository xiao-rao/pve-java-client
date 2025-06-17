package io.github.pve.client.resource.nodes.qemu.status.stop;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.qemu.status.stop.*;

/**
 * Client for /nodes/{node}/qemu/{vmid}/status/stop
 * BY '@xiao-rao'
 */
public class StopClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public StopClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/qemu/{vmid}/status/stop".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Stop virtual machine. The qemu process will exit immediately. This is akin to pulling the power plug of a running computer and may damage the VM data.
     */
    public String vmStop(VmStopRequest request) {
        PveResponse<String> response = executor.post(this.basePath, request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}