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
    protected final String vmid;

    public CloudinitClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/qemu/{vmid}/cloudinit".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Get the cloudinit configuration with both current and pending values.
     */
    public CloudinitPendingResponse cloudinitPending() {
        PveResponse<CloudinitPendingResponse> response = executor.get(this.basePath, null, new TypeReference<>() {});
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
        return new DumpClient(this.executor, this.node, this.vmid);
    }
}