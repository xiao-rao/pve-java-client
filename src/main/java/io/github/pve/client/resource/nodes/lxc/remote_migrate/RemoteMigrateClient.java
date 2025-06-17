package io.github.pve.client.resource.nodes.lxc.remote_migrate;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.lxc.remote_migrate.*;

/**
 * Client for /nodes/{node}/lxc/{vmid}/remote_migrate
 * BY '@xiao-rao'
 */
public class RemoteMigrateClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public RemoteMigrateClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/lxc/{vmid}/remote_migrate".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Migrate the container to another cluster. Creates a new migration task. EXPERIMENTAL feature!
     */
    public String remoteMigrateVm(RemoteMigrateVmRequest request) {
        PveResponse<String> response = executor.post(this.basePath + "/" + request.getTargetVmid(), request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}