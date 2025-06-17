package io.github.pve.client.resource.cluster.log;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /cluster/log
 * BY '@xiao-rao'
 */
public class LogClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public LogClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/log";
    }

    /**
     * Read cluster log
     */
    public List<Object> log(Integer max) {
        Map<String, Object> queryParams = new HashMap<>();
        if (max != null) {
            queryParams.put("max", max);
        }
        PveResponse<List<Object>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}