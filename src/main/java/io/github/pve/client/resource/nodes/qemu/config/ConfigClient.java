package io.github.pve.client.resource.nodes.qemu.config;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.qemu.config.*;

/**
 * Client for /nodes/{node}/qemu/{vmid}/config
 * BY '@xiao-rao'
 */
public class ConfigClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public ConfigClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/qemu/{vmid}/config".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Get the virtual machine configuration with pending configuration changes applied. Set the 'current' parameter to get the current configuration instead.
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
     * Set virtual machine options (asynchronous API).
     */
    public String updateVmAsync(UpdateVmAsyncRequest request) {
        PveResponse<String> response = executor.post(this.basePath + "/" + request.getVmgenid(), request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Set virtual machine options (synchronous API) - You should consider using the POST method instead for any actions involving hotplug or storage allocation.
     */
    public void updateVm(UpdateVmRequest request) {
        executor.put(this.basePath + "/" + request.getVmgenid(), request);
    }
}