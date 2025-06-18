package io.github.pve.client.resource.cluster.replication;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.replication.*;

/**
 * Client for /cluster/replication
 * BY '@xiao-rao'
 */
public class ReplicationClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public ReplicationClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/replication";
    }

    /**
     * List replication jobs.
     */
    public List<Object> index() {
        PveResponse<List<Object>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create a new replication job
     */
    public void create(CreateRequest request) {
        executor.post(this.basePath, request);
    }

    /**
     * Mark replication job for removal.
     */
    public void delete(String id, Boolean force, Boolean keep) {
        String path = this.basePath + "/" + id;
        Map<String, Object> options = new HashMap<>();
        if (force != null) {
            options.put("force", force);
        }
        if (keep != null) {
            options.put("keep", keep);
        }
        executor.delete(path, options);
    }

    /**
     * Read replication job configuration.
     */
    public Map<String, Object> read(String id) {
        PveResponse<Map<String, Object>> response = executor.get(this.basePath + "/" + id, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Update replication job configuration.
     */
    public void update(UpdateRequest request) {
        executor.put(this.basePath + "/" + request.getId(), request);
    }
}