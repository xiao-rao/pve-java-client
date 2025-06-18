package io.github.pve.client.resource.nodes.disks.zfs;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.disks.zfs.*;

/**
 * Client for /nodes/{node}/disks/zfs
 * BY '@xiao-rao'
 */
public class ZfsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public ZfsClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/disks/zfs".replace("{" + "node" + "}", node);
    }

    /**
     * List Zpools.
     */
    public List<DisksZfsIndexResponse> index() {
        PveResponse<List<DisksZfsIndexResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create a ZFS pool.
     */
    public String create(CreateRequest request) {
        PveResponse<String> response = executor.post(this.basePath, request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Destroy a ZFS pool.
     */
    public String delete(String name, Boolean cleanupConfig, Boolean cleanupDisks) {
        String path = this.basePath + "/" + name;
        Map<String, Object> options = new HashMap<>();
        if (cleanupConfig != null) {
            options.put("cleanup-config", cleanupConfig);
        }
        if (cleanupDisks != null) {
            options.put("cleanup-disks", cleanupDisks);
        }
        PveResponse<String> response = executor.delete(path, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Get details about a zpool.
     */
    public DetailResponse detail(String name) {
        PveResponse<DetailResponse> response = executor.get(this.basePath + "/" + name, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}