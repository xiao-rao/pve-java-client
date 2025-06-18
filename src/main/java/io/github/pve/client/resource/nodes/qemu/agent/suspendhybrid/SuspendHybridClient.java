package io.github.pve.client.resource.nodes.qemu.agent.suspendhybrid;

import java.util.Map;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/qemu/{vmid}/agent/suspend-hybrid
 * BY '@xiao-rao'
 */
public class SuspendHybridClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public SuspendHybridClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/qemu/{vmid}/agent/suspend-hybrid".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmId);
    }

    /**
     * Execute suspend-hybrid.
     */
    public Map<String, Object> suspendHybrId() {
        PveResponse<Map<String, Object>> response = executor.post(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}