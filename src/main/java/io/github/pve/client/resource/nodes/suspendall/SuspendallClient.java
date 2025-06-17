package io.github.pve.client.resource.nodes.suspendall;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/suspendall
 * BY '@xiao-rao'
 */
public class SuspendallClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public SuspendallClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/suspendall".replace("{" + "node" + "}", node);
    }

    /**
     * Suspend all VMs.
     */
    public String suspendall(String vms) {
        Map<String, Object> options = new HashMap<>();
        if (vms != null) {
            options.put("vms", vms);
        }
        PveResponse<String> response = executor.post(this.basePath, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}