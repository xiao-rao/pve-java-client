package io.github.pve.client.resource.nodes.lxc.feature;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.lxc.feature.*;

/**
 * Client for /nodes/{node}/lxc/{vmid}/feature
 * BY '@xiao-rao'
 */
public class FeatureClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public FeatureClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/lxc/{vmid}/feature".replace("{node}", node).replace("{vmid}", vmId);
    }

    /**
     * Check if feature for virtual machine is available.
     */
    public VmFeatureResponse vmFeature(String feature, String snapname) {
        Map<String, Object> queryParams = new HashMap<>();
        if (feature != null) {
            queryParams.put("feature", feature);
        }
        if (snapname != null) {
            queryParams.put("snapname", snapname);
        }
        PveResponse<VmFeatureResponse> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}