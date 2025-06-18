package io.github.pve.client.resource.nodes.qemu.clone;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.qemu.clone.*;

/**
 * Client for /nodes/{node}/qemu/{vmid}/clone
 * BY '@xiao-rao'
 */
public class CloneClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public CloneClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/qemu/{vmid}/clone".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmId);
    }

    /**
     * Create a copy of virtual machine/template.
     */
    public String cloneVm(CloneVmRequest request) {
        PveResponse<String> response = executor.post(this.basePath + "/" + request.getNewId() + "/" + request.getStorage(), request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}