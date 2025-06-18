package io.github.pve.client.resource.nodes.qemu.move_disk;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.qemu.move_disk.*;

/**
 * Client for /nodes/{node}/qemu/{vmid}/move_disk
 * BY '@xiao-rao'
 */
public class MoveDiskClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public MoveDiskClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/qemu/{vmid}/move_disk".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmId);
    }

    /**
     * Move volume to different storage or to a different VM.
     */
    public String moveVmDisk(MoveVmDiskRequest request) {
        PveResponse<String> response = executor.post(this.basePath + "/" + request.getStorage() + "/" + request.getTargetVmId(), request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}