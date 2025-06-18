package io.github.pve.client.resource.nodes.qemu.agent.gettimezone;

import java.util.Map;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/qemu/{vmid}/agent/get-timezone
 * BY '@xiao-rao'
 */
public class GetTimezoneClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public GetTimezoneClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/qemu/{vmid}/agent/get-timezone".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmId);
    }

    /**
     * Execute get-timezone.
     */
    public Map<String, Object> getTimezone() {
        PveResponse<Map<String, Object>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}