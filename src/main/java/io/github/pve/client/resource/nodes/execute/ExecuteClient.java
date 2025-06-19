package io.github.pve.client.resource.nodes.execute;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/execute
 * BY '@xiao-rao'
 */
public class ExecuteClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public ExecuteClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/execute".replace("{node}", node);
    }

    /**
     * Execute multiple commands in order, root only.
     */
    public List<Object> execute(String commands) {
        Map<String, Object> options = new HashMap<>();
        if (commands != null) {
            options.put("commands", commands);
        }
        PveResponse<List<Object>> response = executor.post(this.basePath, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}