package io.github.pve.client.resource.cluster.config.join;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.config.join.*;

/**
 * Client for /cluster/config/join
 * BY '@xiao-rao'
 */
public class JoinClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public JoinClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/config/join";
    }

    /**
     * Get information needed to join this cluster over the connected node.
     */
    public JoinInfoResponse joinInfo(String node) {
        Map<String, Object> queryParams = new HashMap<>();
        if (node != null) {
            queryParams.put("node", node);
        }
        PveResponse<JoinInfoResponse> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Joins this node into an existing cluster. If no links are given, default to IP resolved by node's hostname on single link (fallback fails for clusters with multiple links).
     */
    public String join(JoinRequest request) {
        PveResponse<String> response = executor.post(this.basePath, request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}