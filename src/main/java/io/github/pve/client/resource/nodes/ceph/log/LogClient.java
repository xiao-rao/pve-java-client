package io.github.pve.client.resource.nodes.ceph.log;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.ceph.log.*;

/**
 * Client for /nodes/{node}/ceph/log
 * BY '@xiao-rao'
 */
public class LogClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public LogClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/ceph/log".replace("{node}", node);
    }

    /**
     * Read ceph log
     */
    public List<LogResponse> log(Integer limit, Integer start) {
        Map<String, Object> queryParams = new HashMap<>();
        if (limit != null) {
            queryParams.put("limit", limit);
        }
        if (start != null) {
            queryParams.put("start", start);
        }
        PveResponse<List<LogResponse>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}