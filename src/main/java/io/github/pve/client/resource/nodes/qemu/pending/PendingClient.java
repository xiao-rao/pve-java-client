package io.github.pve.client.resource.nodes.qemu.pending;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.qemu.pending.*;

/**
 * Client for /nodes/{node}/qemu/{vmid}/pending
 * BY '@xiao-rao'
 */
public class PendingClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public PendingClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/qemu/{vmid}/pending".replace("{node}", node).replace("{vmid}", vmId);
    }

    /**
     * Get the virtual machine configuration with both current and pending values.
     */
    public List<VmPendingResponse> vmPending() {
        PveResponse<List<VmPendingResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}