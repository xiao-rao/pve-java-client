package io.github.pve.client.resource.cluster.resources;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.resources.*;

/**
 * Client for /cluster/resources
 * BY '@xiao-rao'
 */
public class ResourcesClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public ResourcesClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/resources";
    }

    /**
     * Resources index (cluster wide).
     */
    public ResourcesResponse resources(String type) {
        Map<String, Object> queryParams = new HashMap<>();
        if (type != null) {
            queryParams.put("type", type);
        }
        PveResponse<ResourcesResponse> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}