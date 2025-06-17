package io.github.pve.client.resource.nodes.lxc.move_volume;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.lxc.move_volume.*;

/**
 * Client for /nodes/{node}/lxc/{vmid}/move_volume
 * BY '@xiao-rao'
 */
public class MoveVolumeClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public MoveVolumeClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/lxc/{vmid}/move_volume".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Move a rootfs-/mp-volume to a different storage or to a different container.
     */
    public String moveVolume(MoveVolumeRequest request) {
        PveResponse<String> response = executor.post(this.basePath + "/" + request.getStorage() + "/" + request.getTargetVmid(), request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}