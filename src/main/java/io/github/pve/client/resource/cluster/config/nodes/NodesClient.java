package io.github.pve.client.resource.cluster.config.nodes;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.config.nodes.*;

/**
 * Client for /cluster/config/nodes
 * BY '@xiao-rao'
 */
public class NodesClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public NodesClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/config/nodes";
    }

    /**
     * Corosync node list.
     */
    public List<NodesResponse> nodes() {
        PveResponse<List<NodesResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Removes a node from the cluster configuration.
     */
    public void delnode(String node) {
        executor.delete(this.basePath + "/" + node);
    }

    /**
     * Adds a node to the cluster configuration. This call is for internal use.
     */
    public AddnodeResponse addnode(AddnodeRequest request) {
        PveResponse<AddnodeResponse> response = executor.post(this.basePath + "/" + request.getNode(), request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}