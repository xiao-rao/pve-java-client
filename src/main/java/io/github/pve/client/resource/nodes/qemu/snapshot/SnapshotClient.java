package io.github.pve.client.resource.nodes.qemu.snapshot;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.qemu.snapshot.config.ConfigClient;
import io.github.pve.client.resource.nodes.qemu.snapshot.rollback.RollbackClient;
// Import models if needed
import io.github.pve.client.model.nodes.qemu.snapshot.*;

/**
 * Client for /nodes/{node}/qemu/{vmid}/snapshot
 * BY '@xiao-rao'
 */
public class SnapshotClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public SnapshotClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/qemu/{vmid}/snapshot".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * List all snapshots.
     */
    public SnapshotListResponse snapshotList() {
        PveResponse<SnapshotListResponse> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Snapshot a VM.
     */
    public String snapshot(SnapshotRequest request) {
        PveResponse<String> response = executor.post(this.basePath, request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Delete a VM snapshot.
     */
    public void delsnapshot(String snapname, Boolean force) {
        String path = this.basePath + "/" + snapname;
        Map<String, Object> options = new HashMap<>();
        if (force != null) {
            options.put("force", force);
        }
        executor.delete(path, options);
    }

    /**
     * 
     */
    public void snapshotCmdIdx(String snapname) {
        executor.get(this.basePath + "/" + snapname);
    }

    /**
     * Client for the specific `snapname` resource.
     * @param snapname The path parameter `snapname`.
     */
    public ConfigClient config(String snapname) {
        return new ConfigClient(this.executor, this.node, this.vmid, snapname);
    }

    /**
     * Client for the specific `snapname` resource.
     * @param snapname The path parameter `snapname`.
     */
    public RollbackClient rollback(String snapname) {
        return new RollbackClient(this.executor, this.node, this.vmid, snapname);
    }
}