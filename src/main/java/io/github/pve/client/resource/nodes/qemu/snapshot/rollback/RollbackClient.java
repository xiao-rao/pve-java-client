package io.github.pve.client.resource.nodes.qemu.snapshot.rollback;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/qemu/{vmid}/snapshot/{snapname}/rollback
 * BY '@xiao-rao'
 */
public class RollbackClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;
    protected final String snapname;

    public RollbackClient(ProxmoxApiExecutor executor, String node, String vmid, String snapname) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.snapname = snapname;
        this.basePath = "/nodes/{node}/qemu/{vmid}/snapshot/{snapname}/rollback".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid).replace("{" + "snapname" + "}", snapname);
    }

    /**
     * Rollback VM state to specified snapshot.
     */
    public String rollback(Boolean start) {
        Map<String, Object> options = new HashMap<>();
        if (start != null) {
            options.put("start", start);
        }
        PveResponse<String> response = executor.post(this.basePath, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}