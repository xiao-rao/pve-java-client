package io.github.pve.client.resource.nodes.lxc.status.start;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/lxc/{vmid}/status/start
 * BY '@xiao-rao'
 */
public class StartClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public StartClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/lxc/{vmid}/status/start".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Start the container.
     */
    public String vmStart(Boolean debug, Boolean skiplock) {
        Map<String, Object> options = new HashMap<>();
        if (debug != null) {
            options.put("debug", debug);
        }
        if (skiplock != null) {
            options.put("skiplock", skiplock);
        }
        PveResponse<String> response = executor.post(this.basePath, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}