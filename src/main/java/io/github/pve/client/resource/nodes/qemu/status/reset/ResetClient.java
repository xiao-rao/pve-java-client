package io.github.pve.client.resource.nodes.qemu.status.reset;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/qemu/{vmid}/status/reset
 * BY '@xiao-rao'
 */
public class ResetClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public ResetClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/qemu/{vmid}/status/reset".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Reset virtual machine.
     */
    public String vmReset(Boolean skiplock) {
        Map<String, Object> options = new HashMap<>();
        if (skiplock != null) {
            options.put("skiplock", skiplock);
        }
        PveResponse<String> response = executor.post(this.basePath, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}