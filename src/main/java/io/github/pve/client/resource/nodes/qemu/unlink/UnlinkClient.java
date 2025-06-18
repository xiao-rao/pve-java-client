package io.github.pve.client.resource.nodes.qemu.unlink;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/qemu/{vmid}/unlink
 * BY '@xiao-rao'
 */
public class UnlinkClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public UnlinkClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/qemu/{vmid}/unlink".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmId);
    }

    /**
     * Unlink/delete disk images.
     */
    public void unlink(Boolean force, String idlist) {
        Map<String, Object> options = new HashMap<>();
        if (force != null) {
            options.put("force", force);
        }
        if (idlist != null) {
            options.put("idlist", idlist);
        }
        executor.put(this.basePath, options);
    }
}