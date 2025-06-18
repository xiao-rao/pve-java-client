package io.github.pve.client.resource.nodes.lxc.status.shutdown;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/lxc/{vmid}/status/shutdown
 * BY '@xiao-rao'
 */
public class ShutdownClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public ShutdownClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/lxc/{vmid}/status/shutdown".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmId);
    }

    /**
     * Shutdown the container. This will trigger a clean shutdown of the container, see lxc-stop(1) for details.
     */
    public String vmShutdown(Boolean forcestop, Integer timeout) {
        Map<String, Object> options = new HashMap<>();
        if (forcestop != null) {
            options.put("forceStop", forcestop);
        }
        if (timeout != null) {
            options.put("timeout", timeout);
        }
        PveResponse<String> response = executor.post(this.basePath, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}