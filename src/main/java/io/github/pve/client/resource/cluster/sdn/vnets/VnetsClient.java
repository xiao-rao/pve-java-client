package io.github.pve.client.resource.cluster.sdn.vnets;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.cluster.sdn.vnets.firewall.FirewallClient;
import io.github.pve.client.resource.cluster.sdn.vnets.subnets.SubnetsClient;
import io.github.pve.client.resource.cluster.sdn.vnets.ips.IpsClient;
// Import models if needed
import io.github.pve.client.model.cluster.sdn.vnets.*;

/**
 * Client for /cluster/sdn/vnets
 * BY '@xiao-rao'
 */
public class VnetsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public VnetsClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/sdn/vnets";
    }

    /**
     * SDN vnets index.
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
     * Create a new sdn vnet object.
     */
    public void create(CreateRequest request) {
        executor.post(this.basePath, request);
    }

    /**
     * Delete sdn vnet object configuration.
     */
    public void delete(String vnet) {
        executor.delete(this.basePath + "/" + vnet);
    }

    /**
     * Read sdn vnet configuration.
     */
    public void read(String vnet, Boolean pending, Boolean running) {
        String path = this.basePath + "/" + vnet;
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
     * Update sdn vnet object configuration.
     */
    public void update(UpdateRequest request) {
        executor.put(this.basePath + "/" + request.getVnet(), request);
    }

    /**
     * Client for the specific `vnet` resource.
     * @param vnet The path parameter `vnet`.
     */
    public FirewallClient firewall(String vnet) {
        return new FirewallClient(this.executor, vnet);
    }

    /**
     * Client for the specific `vnet` resource.
     * @param vnet The path parameter `vnet`.
     */
    public SubnetsClient subnets(String vnet) {
        return new SubnetsClient(this.executor, vnet);
    }

    /**
     * Client for the specific `vnet` resource.
     * @param vnet The path parameter `vnet`.
     */
    public IpsClient ips(String vnet) {
        return new IpsClient(this.executor, vnet);
    }
}