package io.github.pve.client.resource.nodes.qemu.status.resume;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/qemu/{vmid}/status/resume
 * BY '@xiao-rao'
 */
public class ResumeClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public ResumeClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/qemu/{vmid}/status/resume".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Resume virtual machine.
     */
    public String vmResume(Boolean nocheck, Boolean skiplock) {
        Map<String, Object> options = new HashMap<>();
        if (nocheck != null) {
            options.put("nocheck", nocheck);
        }
        if (skiplock != null) {
            options.put("skiplock", skiplock);
        }
        PveResponse<String> response = executor.post(this.basePath, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}