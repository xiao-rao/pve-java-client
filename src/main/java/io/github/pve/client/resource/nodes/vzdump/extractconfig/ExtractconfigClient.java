package io.github.pve.client.resource.nodes.vzdump.extractconfig;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/vzdump/extractconfig
 * BY '@xiao-rao'
 */
public class ExtractconfigClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public ExtractconfigClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/vzdump/extractconfig".replace("{" + "node" + "}", node);
    }

    /**
     * Extract configuration from vzdump backup archive.
     */
    public String extractconfig(String volume) {
        Map<String, Object> queryParams = new HashMap<>();
        if (volume != null) {
            queryParams.put("volume", volume);
        }
        PveResponse<String> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}