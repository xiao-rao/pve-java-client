package io.github.pve.client.resource.nodes.ceph.pool;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.ceph.pool.status.StatusClient;
// Import models if needed
import io.github.pve.client.model.nodes.ceph.pool.*;

/**
 * Client for /nodes/{node}/ceph/pool
 * BY '@xiao-rao'
 */
public class PoolClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public PoolClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/ceph/pool".replace("{" + "node" + "}", node);
    }

    /**
     * List all pools and their settings (which are settable by the POST/PUT endpoints).
     */
    public List<LspoolsResponse> lspools() {
        PveResponse<List<LspoolsResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create Ceph pool
     */
    public String createpool(CreatepoolRequest request) {
        PveResponse<String> response = executor.post(this.basePath, request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Destroy pool
     */
    public String destroypool(String name, Boolean force, Boolean removeEcprofile, Boolean removeStorages) {
        String path = this.basePath + "/" + name;
        Map<String, Object> options = new HashMap<>();
        if (force != null) {
            options.put("force", force);
        }
        if (removeEcprofile != null) {
            options.put("remove_ecprofile", removeEcprofile);
        }
        if (removeStorages != null) {
            options.put("remove_storages", removeStorages);
        }
        PveResponse<String> response = executor.delete(path, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Pool index.
     */
    public List<Object> poolindex(String name) {
        PveResponse<List<Object>> response = executor.get(this.basePath + "/" + name, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Change POOL settings
     */
    public String setpool(SetpoolRequest request) {
        PveResponse<String> response = executor.put(this.basePath + "/" + request.getName(), request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Client for the specific `name` resource.
     * @param name The path parameter `name`.
     */
    public StatusClient status(String name) {
        return new StatusClient(this.executor, this.node, name);
    }
}