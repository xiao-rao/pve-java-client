package io.github.pve.client.resource.nodes.tasks.log;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/tasks/{upid}/log
 * BY '@xiao-rao'
 */
public class LogClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String upid;

    public LogClient(ProxmoxApiExecutor executor, String node, String upid) {
        this.executor = executor;
        this.node = node;
        this.upid = upid;
        this.basePath = "/nodes/{node}/tasks/{upid}/log".replace("{" + "node" + "}", node).replace("{" + "upid" + "}", upid);
    }

    /**
     * Read task log.
     */
    public List<Object> readTaskLog(Boolean download, Integer limit, Integer start) {
        Map<String, Object> queryParams = new HashMap<>();
        if (download != null) {
            queryParams.put("download", download);
        }
        if (limit != null) {
            queryParams.put("limit", limit);
        }
        if (start != null) {
            queryParams.put("start", start);
        }
        PveResponse<List<Object>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}