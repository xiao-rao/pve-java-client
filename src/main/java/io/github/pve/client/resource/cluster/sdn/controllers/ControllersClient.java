package io.github.pve.client.resource.cluster.sdn.controllers;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.sdn.controllers.*;

/**
 * Client for /cluster/sdn/controllers
 * BY '@xiao-rao'
 */
public class ControllersClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public ControllersClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/sdn/controllers";
    }

    /**
     * SDN controllers index.
     */
    public List<SdnControllersIndexResponse> index(Boolean pending, Boolean running, String type) {
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
        PveResponse<List<SdnControllersIndexResponse>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create a new sdn controller object.
     */
    public void create(CreateRequest request) {
        executor.post(this.basePath, request);
    }

    /**
     * Delete sdn controller object configuration.
     */
    public void delete(String controller) {
        executor.delete(this.basePath + "/" + controller);
    }

    /**
     * Read sdn controller configuration.
     */
    public Map<String, Object> read(String controller, Boolean pending, Boolean running) {
        String path = this.basePath + "/" + controller;
        Map<String, Object> queryParams = new HashMap<>();
        if (pending != null) {
            queryParams.put("pending", pending);
        }
        if (running != null) {
            queryParams.put("running", running);
        }
        PveResponse<Map<String, Object>> response = executor.get(path, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Update sdn controller object configuration.
     */
    public void update(UpdateRequest request) {
        executor.put(this.basePath + "/" + request.getController(), request);
    }
}