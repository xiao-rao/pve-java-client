package io.github.pve.client.resource.nodes.qemu.firewall.options;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.qemu.firewall.options.*;

/**
 * Client for /nodes/{node}/qemu/{vmid}/firewall/options
 * BY '@xiao-rao'
 */
public class OptionsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public OptionsClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/qemu/{vmid}/firewall/options".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Get VM firewall options.
     */
    public GetOptionsResponse getOptions() {
        PveResponse<GetOptionsResponse> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Set Firewall options.
     */
    public void setOptions(SetOptionsRequest request) {
        executor.put(this.basePath, request);
    }
}