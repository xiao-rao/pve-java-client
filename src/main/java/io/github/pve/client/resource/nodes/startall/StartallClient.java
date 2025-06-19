package io.github.pve.client.resource.nodes.startall;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/startall
 * BY '@xiao-rao'
 */
public class StartallClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public StartallClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/startall".replace("{node}", node);
    }

    /**
     * Start all VMs and containers located on this node (by default only those with onboot=1).
     */
    public String startall(Boolean force, String vms) {
        Map<String, Object> options = new HashMap<>();
        if (force != null) {
            options.put("force", force);
        }
        if (vms != null) {
            options.put("vms", vms);
        }
        PveResponse<String> response = executor.post(this.basePath, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}