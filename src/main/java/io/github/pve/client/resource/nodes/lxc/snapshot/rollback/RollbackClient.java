package io.github.pve.client.resource.nodes.lxc.snapshot.rollback;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/lxc/{vmid}/snapshot/{snapname}/rollback
 * BY '@xiao-rao'
 */
public class RollbackClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;
    protected final String snapname;

    public RollbackClient(ProxmoxApiExecutor executor, String node, String vmId, String snapname) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.snapname = snapname;
        this.basePath = "/nodes/{node}/lxc/{vmid}/snapshot/{snapname}/rollback".replace("{node}", node).replace("{vmid}", vmId).replace("{snapname}", snapname);
    }

    /**
     * Rollback LXC state to specified snapshot.
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