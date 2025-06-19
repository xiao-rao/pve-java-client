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
    protected final String vmId;

    public SuspendClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/lxc/{vmid}/status/suspend".replace("{node}", node).replace("{vmid}", vmId);
    }

    /**
     * Suspend the container. This is experimental.
     */
    public String vmSuspend() {
        PveResponse<String> response = executor.post(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}