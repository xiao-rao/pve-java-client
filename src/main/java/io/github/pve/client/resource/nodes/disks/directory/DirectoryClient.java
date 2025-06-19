package io.github.pve.client.resource.nodes.disks.directory;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.disks.directory.*;

/**
 * Client for /nodes/{node}/disks/directory
 * BY '@xiao-rao'
 */
public class DirectoryClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public DirectoryClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/disks/directory".replace("{node}", node);
    }

    /**
     * PVE Managed Directory storages.
     */
    public List<DisksDirectoryIndexResponse> index() {
        PveResponse<List<DisksDirectoryIndexResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create a Filesystem on an unused disk. Will be mounted under '/mnt/pve/NAME'.
     */
    public String create(CreateRequest request) {
        PveResponse<String> response = executor.post(this.basePath, request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Unmounts the storage and removes the mount unit.
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
}