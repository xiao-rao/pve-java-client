package io.github.pve.client.resource.cluster.ha.resources;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.cluster.ha.resources.migrate.MigrateClient;
import io.github.pve.client.resource.cluster.ha.resources.relocate.RelocateClient;
// Import models if needed
import io.github.pve.client.model.cluster.ha.resources.*;

/**
 * Client for /cluster/ha/resources
 * BY '@xiao-rao'
 */
public class ResourcesClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public ResourcesClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/ha/resources";
    }

    /**
     * List HA resources.
     */
    public List<Object> index(String type) {
        Map<String, Object> queryParams = new HashMap<>();
        if (type != null) {
            queryParams.put("type", type);
        }
        PveResponse<List<Object>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create a new HA resource.
     */
    public void create(CreateRequest request) {
        executor.post(this.basePath, request);
    }

    /**
     * Delete resource configuration.
     */
    public void delete(String sid) {
        executor.delete(this.basePath + "/" + sid);
    }

    /**
     * Read resource configuration.
     */
    public ReadResponse read(String sid) {
        PveResponse<ReadResponse> response = executor.get(this.basePath + "/" + sid, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Update resource configuration.
     */
    public void update(UpdateRequest request) {
        executor.put(this.basePath + "/" + request.getSid(), request);
    }

    /**
     * Client for the specific `sid` resource.
     * @param sid The path parameter `sid`.
     */
    public MigrateClient migrate(String sid) {
        return new MigrateClient(this.executor, sid);
    }

    /**
     * Client for the specific `sid` resource.
     * @param sid The path parameter `sid`.
     */
    public RelocateClient relocate(String sid) {
        return new RelocateClient(this.executor, sid);
    }
}