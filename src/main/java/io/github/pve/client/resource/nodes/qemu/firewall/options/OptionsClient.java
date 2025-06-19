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
    protected final String vmId;

    public OptionsClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/qemu/{vmid}/firewall/options".replace("{node}", node).replace("{vmid}", vmId);
    }

    /**
     * Get VM firewall options.
     */
    public GetOptionsResponse getOptions() {
        PveResponse<GetOptionsResponse> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Set Firewall options.
     */
    public void setOptions(SetOptionsRequest request) {
        executor.put(this.basePath, request);
    }
}