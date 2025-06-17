package io.github.pve.client.resource.nodes.disks.lvmthin;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.disks.lvmthin.*;

/**
 * Client for /nodes/{node}/disks/lvmthin
 * BY '@xiao-rao'
 */
public class LvmthinClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public LvmthinClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/disks/lvmthin".replace("{" + "node" + "}", node);
    }

    /**
     * List LVM thinpools
     */
    public IndexResponse index() {
        PveResponse<IndexResponse> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create an LVM thinpool
     */
    public String create(CreateRequest request) {
        PveResponse<String> response = executor.post(this.basePath, request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Remove an LVM thin pool.
     */
    public void delete(String name, Boolean cleanupConfig, Boolean cleanupDisks, String volumeGroup) {
        String path = this.basePath + "/" + name;
        Map<String, Object> options = new HashMap<>();
        if (cleanupConfig != null) {
            options.put("cleanup-config", cleanupConfig);
        }
        if (cleanupDisks != null) {
            options.put("cleanup-disks", cleanupDisks);
        }
        if (volumeGroup != null) {
            options.put("volume-group", volumeGroup);
        }
        executor.delete(path, options);
    }
}