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
    protected final String vmId;

    public InterfacesClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/lxc/{vmid}/interfaces".replace("{node}", node).replace("{vmid}", vmId);
    }

    /**
     * Get IP addresses of the specified container interface.
     */
    public List<IpResponse> ip() {
        PveResponse<List<IpResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}