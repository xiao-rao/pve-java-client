package io.github.pve.client.resource.nodes.qemu.snapshot.config;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/qemu/{vmid}/snapshot/{snapname}/config
 * BY '@xiao-rao'
 */
public class ConfigClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;
    protected final String snapname;

    public ConfigClient(ProxmoxApiExecutor executor, String node, String vmid, String snapname) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.snapname = snapname;
        this.basePath = "/nodes/{node}/qemu/{vmid}/snapshot/{snapname}/config".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid).replace("{" + "snapname" + "}", snapname);
    }

    /**
     * Get snapshot configuration
     */
    public Map<String, Object> getSnapshotConfig() {
        PveResponse<Map<String, Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Update snapshot metadata.
     */
    public void updateSnapshotConfig(String description) {
        Map<String, Object> options = new HashMap<>();
        if (description != null) {
            options.put("description", description);
        }
        executor.put(this.basePath, options);
    }
}