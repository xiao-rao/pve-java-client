package io.github.pve.client.resource.cluster.mapping.dir;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.mapping.dir.*;

/**
 * Client for /cluster/mapping/dir
 * BY '@xiao-rao'
 */
public class DirClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public DirClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/mapping/dir";
    }

    /**
     * List directory mapping
     */
    public IndexResponse index(String checkNode) {
        Map<String, Object> queryParams = new HashMap<>();
        if (checkNode != null) {
            queryParams.put("check-node", checkNode);
        }
        PveResponse<IndexResponse> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create a new directory mapping.
     */
    public void create(CreateRequest request) {
        executor.post(this.basePath, request);
    }

    /**
     * Remove directory mapping.
     */
    public void delete(String id) {
        executor.delete(this.basePath + "/" + id);
    }

    /**
     * Get directory mapping.
     */
    public void get(String id) {
        executor.get(this.basePath + "/" + id);
    }

    /**
     * Update a directory mapping.
     */
    public void update(UpdateRequest request) {
        executor.put(this.basePath + "/" + request.getId(), request);
    }
}