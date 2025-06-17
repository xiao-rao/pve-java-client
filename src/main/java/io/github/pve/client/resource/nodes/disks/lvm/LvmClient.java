package io.github.pve.client.resource.nodes.disks.lvm;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.disks.lvm.*;

/**
 * Client for /nodes/{node}/disks/lvm
 * BY '@xiao-rao'
 */
public class LvmClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public LvmClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/disks/lvm".replace("{" + "node" + "}", node);
    }

    /**
     * List LVM Volume Groups
     */
    public Object index() {
        PveResponse<Object> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create an LVM Volume Group
     */
    public String create(CreateRequest request) {
        PveResponse<String> response = executor.post(this.basePath, request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Remove an LVM Volume Group.
     */
    public void delete(String name, Boolean cleanupConfig, Boolean cleanupDisks) {
        String path = this.basePath + "/" + name;
        Map<String, Object> options = new HashMap<>();
        if (cleanupConfig != null) {
            options.put("cleanup-config", cleanupConfig);
        }
        if (cleanupDisks != null) {
            options.put("cleanup-disks", cleanupDisks);
        }
        executor.delete(path, options);
    }
}