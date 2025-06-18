package io.github.pve.client.resource.cluster.metrics;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.cluster.metrics.server.ServerClient;
import io.github.pve.client.resource.cluster.metrics.export.ExportClient;

/**
 * Client for /cluster/metrics
 * BY '@xiao-rao'
 */
public class MetricsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public MetricsClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/metrics";
    }

    /**
     * Metrics index.
     */
    public List<Object> index() {
        PveResponse<List<Object>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `server`
     */
    public ServerClient server() {
        return new ServerClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `export`
     */
    public ExportClient export() {
        return new ExportClient(this.executor);
    }
}