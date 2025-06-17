package io.github.pve.client.resource.nodes.lxc.resize;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.lxc.resize.*;

/**
 * Client for /nodes/{node}/lxc/{vmid}/resize
 * BY '@xiao-rao'
 */
public class ResizeClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public ResizeClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/lxc/{vmid}/resize".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Resize a container mount point.
     */
    public String resizeVm(ResizeVmRequest request) {
        PveResponse<String> response = executor.put(this.basePath, request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}