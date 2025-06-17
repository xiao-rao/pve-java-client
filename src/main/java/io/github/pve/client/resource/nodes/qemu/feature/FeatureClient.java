package io.github.pve.client.resource.nodes.qemu.feature;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/qemu/{vmid}/feature
 * BY '@xiao-rao'
 */
public class FeatureClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public FeatureClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/qemu/{vmid}/feature".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Check if feature for virtual machine is available.
     */
    public Object vmFeature(String feature, String snapname) {
        Map<String, Object> queryParams = new HashMap<>();
        if (feature != null) {
            queryParams.put("feature", feature);
        }
        if (snapname != null) {
            queryParams.put("snapname", snapname);
        }
        PveResponse<Object> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}