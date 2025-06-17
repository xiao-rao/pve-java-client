package io.github.pve.client.resource.nodes.lxc.status.stop;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/lxc/{vmid}/status/stop
 * BY '@xiao-rao'
 */
public class StopClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public StopClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/lxc/{vmid}/status/stop".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Stop the container. This will abruptly stop all processes running in the container.
     */
    public String vmStop(Boolean overruleShutdown, Boolean skiplock) {
        Map<String, Object> options = new HashMap<>();
        if (overruleShutdown != null) {
            options.put("overrule-shutdown", overruleShutdown);
        }
        if (skiplock != null) {
            options.put("skiplock", skiplock);
        }
        PveResponse<String> response = executor.post(this.basePath, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}