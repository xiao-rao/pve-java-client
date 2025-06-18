package io.github.pve.client.resource.nodes.lxc.config;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.lxc.config.*;

/**
 * Client for /nodes/{node}/lxc/{vmid}/config
 * BY '@xiao-rao'
 */
public class ConfigClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public ConfigClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/lxc/{vmid}/config".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmId);
    }

    /**
     * Get container configuration.
     */
    public VmConfigResponse vmConfig(Boolean current, String snapshot) {
        Map<String, Object> queryParams = new HashMap<>();
        if (current != null) {
            queryParams.put("current", current);
        }
        if (snapshot != null) {
            queryParams.put("snapshot", snapshot);
        }
        PveResponse<VmConfigResponse> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Set container options.
     */
    public void updateVm(UpdateVmRequest request) {
        executor.put(this.basePath, request);
    }
}