package io.github.pve.client.resource.nodes.lxc.migrate;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.lxc.migrate.*;

/**
 * Client for /nodes/{node}/lxc/{vmid}/migrate
 * BY '@xiao-rao'
 */
public class MigrateClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public MigrateClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/lxc/{vmid}/migrate".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Migrate the container to another node. Creates a new migration task.
     */
    public String migrateVm(MigrateVmRequest request) {
        PveResponse<String> response = executor.post(this.basePath, request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}