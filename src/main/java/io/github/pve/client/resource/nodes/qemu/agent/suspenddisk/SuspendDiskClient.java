package io.github.pve.client.resource.nodes.qemu.agent.suspenddisk;

import java.util.Map;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/qemu/{vmid}/agent/suspend-disk
 * BY '@xiao-rao'
 */
public class SuspendDiskClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public SuspendDiskClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/qemu/{vmid}/agent/suspend-disk".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmId);
    }

    /**
     * Execute suspend-disk.
     */
    public Map<String, Object> suspendDisk() {
        PveResponse<Map<String, Object>> response = executor.post(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}