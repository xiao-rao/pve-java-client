package io.github.pve.client.resource.nodes.lxc.status.resume;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/lxc/{vmid}/status/resume
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
        this.basePath = "/nodes/{node}/lxc/{vmid}/status/resume".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Resume the container.
     */
    public String vmResume() {
        PveResponse<String> response = executor.post(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}