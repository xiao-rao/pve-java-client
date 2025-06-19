package io.github.pve.client.resource.nodes.ceph.pool.status;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.ceph.pool.status.*;

/**
 * Client for /nodes/{node}/ceph/pool/{name}/status
 * BY '@xiao-rao'
 */
public class StatusClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String name;

    public StatusClient(ProxmoxApiExecutor executor, String node, String name) {
        this.executor = executor;
        this.node = node;
        this.name = name;
        this.basePath = "/nodes/{node}/ceph/pool/{name}/status".replace("{node}", node).replace("{name}", name);
    }

    /**
     * Show the current pool status.
     */
    public GetpoolResponse getpool(Boolean verbose) {
        Map<String, Object> queryParams = new HashMap<>();
        if (verbose != null) {
            queryParams.put("verbose", verbose);
        }
        PveResponse<GetpoolResponse> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}