package io.github.pve.client.resource.nodes.network;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.network.*;

/**
 * Client for /nodes/{node}/network
 * BY '@xiao-rao'
 */
public class NetworkClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public NetworkClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/network".replace("{" + "node" + "}", node);
    }

    /**
     * Revert network configuration changes.
     */
    public void revertNetworkChanges() {
        executor.delete(this.basePath);
    }

    /**
     * List available networks
     */
    public List<NodesNetworkIndexResponse> index(String type) {
        Map<String, Object> queryParams = new HashMap<>();
        if (type != null) {
            queryParams.put("type", type);
        }
        PveResponse<List<NodesNetworkIndexResponse>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create network device configuration
     */
    public void createNetwork(CreateNetworkRequest request) {
        executor.post(this.basePath + "/" + request.getVlanId(), request);
    }

    /**
     * Reload network configuration
     */
    public String reloadNetworkConfig() {
        PveResponse<String> response = executor.put(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Delete network device configuration
     */
    public void deleteNetwork(String iface) {
        executor.delete(this.basePath + "/" + iface);
    }

    /**
     * Read network device configuration
     */
    public NetworkConfigResponse networkConfig(String iface) {
        PveResponse<NetworkConfigResponse> response = executor.get(this.basePath + "/" + iface, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Update network device configuration
     */
    public void updateNetwork(UpdateNetworkRequest request) {
        executor.put(this.basePath + "/" + request.getIface(), request);
    }
}