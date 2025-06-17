package io.github.pve.client.resource.cluster.sdn.vnets.subnets;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.sdn.vnets.subnets.*;

/**
 * Client for /cluster/sdn/vnets/{vnet}/subnets
 * BY '@xiao-rao'
 */
public class SubnetsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String vnet;

    public SubnetsClient(ProxmoxApiExecutor executor, String vnet) {
        this.executor = executor;
        this.vnet = vnet;
        this.basePath = "/cluster/sdn/vnets/{vnet}/subnets".replace("{" + "vnet" + "}", vnet);
    }

    /**
     * SDN subnets index.
     */
    public List<Object> index(Boolean pending, Boolean running) {
        Map<String, Object> queryParams = new HashMap<>();
        if (pending != null) {
            queryParams.put("pending", pending);
        }
        if (running != null) {
            queryParams.put("running", running);
        }
        PveResponse<List<Object>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create a new sdn subnet object.
     */
    public void create(CreateRequest request) {
        executor.post(this.basePath, request);
    }

    /**
     * Delete sdn subnet object configuration.
     */
    public void delete(String subnet) {
        executor.delete(this.basePath + "/" + subnet);
    }

    /**
     * Read sdn subnet configuration.
     */
    public void read(String subnet, Boolean pending, Boolean running) {
        String path = this.basePath + "/" + subnet;
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
     * Update sdn subnet object configuration.
     */
    public void update(UpdateRequest request) {
        executor.put(this.basePath + "/" + request.getSubnet(), request);
    }
}