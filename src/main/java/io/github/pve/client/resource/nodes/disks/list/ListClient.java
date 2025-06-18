package io.github.pve.client.resource.nodes.disks.list;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.disks.list.*;

/**
 * Client for /nodes/{node}/disks/list
 * BY '@xiao-rao'
 */
public class ListClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public ListClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/disks/list".replace("{" + "node" + "}", node);
    }

    /**
     * List local disks.
     */
    public List<ListResponse> list(Boolean includePartitions, Boolean skipsmart, String type) {
        Map<String, Object> queryParams = new HashMap<>();
        if (includePartitions != null) {
            queryParams.put("include-partitions", includePartitions);
        }
        if (skipsmart != null) {
            queryParams.put("skipsmart", skipsmart);
        }
        if (type != null) {
            queryParams.put("type", type);
        }
        PveResponse<List<ListResponse>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}