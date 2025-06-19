package io.github.pve.client.resource.nodes.lxc.status.current;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.lxc.status.current.*;

/**
 * Client for /nodes/{node}/lxc/{vmid}/status/current
 * BY '@xiao-rao'
 */
public class CurrentClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public CurrentClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/lxc/{vmid}/status/current".replace("{node}", node).replace("{vmid}", vmId);
    }

    /**
     * Get virtual machine status.
     */
    public VmStatusResponse vmStatus() {
        PveResponse<VmStatusResponse> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}