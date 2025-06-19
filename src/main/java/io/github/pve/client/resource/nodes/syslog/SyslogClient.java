package io.github.pve.client.resource.nodes.syslog;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.syslog.*;

/**
 * Client for /nodes/{node}/syslog
 * BY '@xiao-rao'
 */
public class SyslogClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public SyslogClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/syslog".replace("{node}", node);
    }

    /**
     * Read system log
     */
    public List<SyslogResponse> syslog(Integer limit, String service, String since, Integer start, String until) {
        Map<String, Object> queryParams = new HashMap<>();
        if (limit != null) {
            queryParams.put("limit", limit);
        }
        if (service != null) {
            queryParams.put("service", service);
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
        PveResponse<List<SyslogResponse>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}