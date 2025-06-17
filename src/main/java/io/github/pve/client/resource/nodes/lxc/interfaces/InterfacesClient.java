package io.github.pve.client.resource.nodes.lxc.interfaces;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.lxc.interfaces.*;

/**
 * Client for /nodes/{node}/lxc/{vmid}/interfaces
 * BY '@xiao-rao'
 */
public class InterfacesClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public InterfacesClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/lxc/{vmid}/interfaces".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Get IP addresses of the specified container interface.
     */
    public IpResponse ip() {
        PveResponse<IpResponse> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}