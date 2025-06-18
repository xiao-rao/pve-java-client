package io.github.pve.client.resource.nodes.storage.rrd;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.storage.rrd.*;

/**
 * Client for /nodes/{node}/storage/{storage}/rrd
 * BY '@xiao-rao'
 */
public class RrdClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String storage;

    public RrdClient(ProxmoxApiExecutor executor, String node, String storage) {
        this.executor = executor;
        this.node = node;
        this.storage = storage;
        this.basePath = "/nodes/{node}/storage/{storage}/rrd".replace("{" + "node" + "}", node).replace("{" + "storage" + "}", storage);
    }

    /**
     * Read storage RRD statistics (returns PNG).
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