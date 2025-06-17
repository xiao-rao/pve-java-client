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
    protected final String vmid;

    public MoveDiskClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/qemu/{vmid}/move_disk".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Move volume to different storage or to a different VM.
     */
    public String moveVmDisk(MoveVmDiskRequest request) {
        PveResponse<String> response = executor.post(this.basePath + "/" + request.getStorage() + "/" + request.getTargetVmid(), request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}