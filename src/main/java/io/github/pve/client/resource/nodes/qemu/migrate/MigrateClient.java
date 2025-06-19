package io.github.pve.client.resource.nodes.qemu.migrate;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.qemu.migrate.*;

/**
 * Client for /nodes/{node}/qemu/{vmid}/migrate
 * BY '@xiao-rao'
 */
public class MigrateClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public MigrateClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/qemu/{vmid}/migrate".replace("{node}", node).replace("{vmid}", vmId);
    }

    /**
     * Get preconditions for migration.
     */
    public MigrateVmPreconditionResponse migrateVmPrecondition(String target) {
        Map<String, Object> queryParams = new HashMap<>();
        if (target != null) {
            queryParams.put("target", target);
        }
        PveResponse<MigrateVmPreconditionResponse> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Migrate virtual machine. Creates a new migration task.
     */
    public String migrateVm(MigrateVmRequest request) {
        PveResponse<String> response = executor.post(this.basePath, request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}