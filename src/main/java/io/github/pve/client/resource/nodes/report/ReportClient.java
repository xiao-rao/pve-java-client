package io.github.pve.client.resource.nodes.report;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/report
 * BY '@xiao-rao'
 */
public class ReportClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public ReportClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/report".replace("{node}", node);
    }

    /**
     * Gather various systems information about a node
     */
    public String report() {
        PveResponse<String> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}