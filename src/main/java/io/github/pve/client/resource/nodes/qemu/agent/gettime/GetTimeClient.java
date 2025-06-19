package io.github.pve.client.resource.nodes.qemu.agent.gettime;

import java.util.Map;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/qemu/{vmid}/agent/get-time
 * BY '@xiao-rao'
 */
public class GetTimeClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public GetTimeClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/qemu/{vmid}/agent/get-time".replace("{node}", node).replace("{vmid}", vmId);
    }

    /**
     * Execute get-time.
     */
    public Map<String, Object> getTime() {
        PveResponse<Map<String, Object>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}