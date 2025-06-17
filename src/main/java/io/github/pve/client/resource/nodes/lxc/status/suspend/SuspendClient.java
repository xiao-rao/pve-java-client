package io.github.pve.client.resource.nodes.lxc.status.suspend;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/lxc/{vmid}/status/suspend
 * BY '@xiao-rao'
 */
public class SuspendClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public SuspendClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/lxc/{vmid}/status/suspend".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Suspend the container. This is experimental.
     */
    public String vmSuspend() {
        PveResponse<String> response = executor.post(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}