package io.github.pve.client.resource.cluster.acme.plugins;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.acme.plugins.*;

/**
 * Client for /cluster/acme/plugins
 * BY '@xiao-rao'
 */
public class PluginsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public PluginsClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/acme/plugins";
    }

    /**
     * ACME plugin index.
     */
    public List<AcmePluginsIndexResponse> index(String type) {
        Map<String, Object> queryParams = new HashMap<>();
        if (type != null) {
            queryParams.put("type", type);
        }
        PveResponse<List<AcmePluginsIndexResponse>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Add ACME plugin configuration.
     */
    public void addPlugin(AddPluginRequest request) {
        executor.post(this.basePath, request);
    }

    /**
     * Delete ACME plugin configuration.
     */
    public void deletePlugin(String id) {
        executor.delete(this.basePath + "/" + id);
    }

    /**
     * Get ACME plugin configuration.
     */
    public Map<String, Object> getPluginConfig(String id) {
        PveResponse<Map<String, Object>> response = executor.get(this.basePath + "/" + id, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Update ACME plugin configuration.
     */
    public void updatePlugin(UpdatePluginRequest request) {
        executor.put(this.basePath + "/" + request.getId(), request);
    }
}