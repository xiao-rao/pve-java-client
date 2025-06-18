package io.github.pve.client.resource.cluster.metrics.export;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.metrics.export.*;

/**
 * Client for /cluster/metrics/export
 * BY '@xiao-rao'
 */
public class ExportClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public ExportClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/metrics/export";
    }

    /**
     * Retrieve metrics of the cluster.
     */
    public ExportResponse export(Boolean history, Boolean localOnly, Integer startTime) {
        Map<String, Object> queryParams = new HashMap<>();
        if (history != null) {
            queryParams.put("history", history);
        }
        if (localOnly != null) {
            queryParams.put("local-only", localOnly);
        }
        if (startTime != null) {
            queryParams.put("start-time", startTime);
        }
        PveResponse<ExportResponse> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}