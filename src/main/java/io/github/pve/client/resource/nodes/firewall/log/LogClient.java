package io.github.pve.client.resource.nodes.firewall.log;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/firewall/log
 * BY '@xiao-rao'
 */
public class LogClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public LogClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/firewall/log".replace("{" + "node" + "}", node);
    }

    /**
     * Read firewall log
     */
    public List<Object> log(Integer limit, Integer since, Integer start, Integer until) {
        Map<String, Object> queryParams = new HashMap<>();
        if (limit != null) {
            queryParams.put("limit", limit);
        }
        if (since != null) {
            queryParams.put("since", since);
        }
        if (start != null) {
            queryParams.put("start", start);
        }
        if (until != null) {
            queryParams.put("until", until);
        }
        PveResponse<List<Object>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}