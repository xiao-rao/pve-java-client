package io.github.pve.client.resource.nodes.lxc.clone;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.lxc.clone.*;

/**
 * Client for /nodes/{node}/lxc/{vmid}/clone
 * BY '@xiao-rao'
 */
public class CloneClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public CloneClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/lxc/{vmid}/clone".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Create a container clone/copy
     */
    public String cloneVm(CloneVmRequest request) {
        PveResponse<String> response = executor.post(this.basePath + "/" + request.getNewid() + "/" + request.getStorage(), request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}