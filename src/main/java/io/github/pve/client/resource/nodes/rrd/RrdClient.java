package io.github.pve.client.resource.nodes.rrd;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.rrd.*;

/**
 * Client for /nodes/{node}/rrd
 * BY '@xiao-rao'
 */
public class RrdClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public RrdClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/rrd".replace("{node}", node);
    }

    /**
     * Read node RRD statistics (returns PNG)
     */
    public RrdResponse rrd(String cf, String ds, String timeframe) {
        Map<String, Object> queryParams = new HashMap<>();
        if (cf != null) {
            queryParams.put("cf", cf);
        }
        if (ds != null) {
            queryParams.put("ds", ds);
        }
        if (timeframe != null) {
            queryParams.put("timeframe", timeframe);
        }
        PveResponse<RrdResponse> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}