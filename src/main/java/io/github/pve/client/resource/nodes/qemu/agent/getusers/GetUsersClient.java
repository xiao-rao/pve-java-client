package io.github.pve.client.resource.nodes.qemu.agent.getusers;

import java.util.Map;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/qemu/{vmid}/agent/get-users
 * BY '@xiao-rao'
 */
public class GetUsersClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public GetUsersClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/qemu/{vmid}/agent/get-users".replace("{node}", node).replace("{vmid}", vmId);
    }

    /**
     * Execute get-users.
     */
    public Map<String, Object> getUsers() {
        PveResponse<Map<String, Object>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}