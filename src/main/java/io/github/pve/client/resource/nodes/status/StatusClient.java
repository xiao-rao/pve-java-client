package io.github.pve.client.resource.nodes.status;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.status.*;

/**
 * Client for /nodes/{node}/status
 * BY '@xiao-rao'
 */
public class StatusClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public StatusClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/status".replace("{node}", node);
    }

    /**
     * Read node status
     */
    public StatusResponse status() {
        PveResponse<StatusResponse> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Reboot or shutdown a node.
     */
    public void nodeCmd(String command) {
        Map<String, Object> options = new HashMap<>();
        if (command != null) {
            options.put("command", command);
        }
        executor.post(this.basePath, options);
    }
}