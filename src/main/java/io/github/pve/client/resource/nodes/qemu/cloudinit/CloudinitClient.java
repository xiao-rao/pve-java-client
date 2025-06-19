package io.github.pve.client.resource.nodes.qemu.cloudinit;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.qemu.cloudinit.dump.DumpClient;
// Import models if needed
import io.github.pve.client.model.nodes.qemu.cloudinit.*;

/**
 * Client for /nodes/{node}/qemu/{vmid}/cloudinit
 * BY '@xiao-rao'
 */
public class CloudinitClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public CloudinitClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/qemu/{vmid}/cloudinit".replace("{node}", node).replace("{vmid}", vmId);
    }

    /**
     * Get the cloudinit configuration with both current and pending values.
     */
    public List<CloudinitPendingResponse> cloudinitPending() {
        PveResponse<List<CloudinitPendingResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Regenerate and change cloudinit config drive.
     */
    public void cloudinitUpdate() {
        executor.put(this.basePath);
    }

    /**
     * Returns a client for the sub-resource: `dump`
     */
    public DumpClient dump() {
        return new DumpClient(this.executor, this.node, this.vmId);
    }
}