package io.github.pve.client.resource.nodes.qemu.agent.shutdown;

import java.util.Map;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/qemu/{vmid}/agent/shutdown
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
        this.basePath = "/nodes/{node}/qemu/{vmid}/agent/shutdown".replace("{node}", node).replace("{vmid}", vmId);
    }

    /**
     * Execute shutdown.
     */
    public Map<String, Object> shutdown() {
        PveResponse<Map<String, Object>> response = executor.post(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}