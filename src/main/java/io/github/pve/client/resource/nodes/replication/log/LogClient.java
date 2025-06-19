package io.github.pve.client.resource.nodes.replication.log;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.replication.log.*;

/**
 * Client for /nodes/{node}/replication/{id}/log
 * BY '@xiao-rao'
 */
public class LogClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String id;

    public LogClient(ProxmoxApiExecutor executor, String node, String id) {
        this.executor = executor;
        this.node = node;
        this.id = id;
        this.basePath = "/nodes/{node}/replication/{id}/log".replace("{node}", node).replace("{id}", id);
    }

    /**
     * Read replication job log.
     */
    public List<ReadJobLogResponse> readJobLog(Integer limit, Integer start) {
        Map<String, Object> queryParams = new HashMap<>();
        if (limit != null) {
            queryParams.put("limit", limit);
        }
        if (start != null) {
            queryParams.put("start", start);
        }
        PveResponse<List<ReadJobLogResponse>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}