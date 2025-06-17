package io.github.pve.client.resource.cluster.sdn.zones;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.sdn.zones.*;

/**
 * Client for /cluster/sdn/zones
 * BY '@xiao-rao'
 */
public class ZonesClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public ZonesClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/sdn/zones";
    }

    /**
     * SDN zones index.
     */
    public IndexResponse index(Boolean pending, Boolean running, String type) {
        Map<String, Object> queryParams = new HashMap<>();
        if (pending != null) {
            queryParams.put("pending", pending);
        }
        if (running != null) {
            queryParams.put("running", running);
        }
        if (type != null) {
            queryParams.put("type", type);
        }
        PveResponse<IndexResponse> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create a new sdn zone object.
     */
    public void create(CreateRequest request) {
        executor.post(this.basePath, request);
    }

    /**
     * Delete sdn zone object configuration.
     */
    public void delete(String zone) {
        executor.delete(this.basePath + "/" + zone);
    }

    /**
     * Read sdn zone configuration.
     */
    public void read(String zone, Boolean pending, Boolean running) {
        String path = this.basePath + "/" + zone;
        Map<String, Object> queryParams = new HashMap<>();
        if (pending != null) {
            queryParams.put("pending", pending);
        }
        if (running != null) {
            queryParams.put("running", running);
        }
        executor.get(path, queryParams);
    }

    /**
     * Update sdn zone object configuration.
     */
    public void update(UpdateRequest request) {
        executor.put(this.basePath + "/" + request.getZone(), request);
    }
}