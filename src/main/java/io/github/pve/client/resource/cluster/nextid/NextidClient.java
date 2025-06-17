package io.github.pve.client.resource.cluster.nextid;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /cluster/nextid
 * BY '@xiao-rao'
 */
public class NextidClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public NextidClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/nextid";
    }

    /**
     * Get next free VMID. Pass a VMID to assert that its free (at time of check).
     */
    public Integer nextid(Integer vmid) {
        Map<String, Object> queryParams = new HashMap<>();
        if (vmid != null) {
            queryParams.put("vmid", vmid);
        }
        PveResponse<Integer> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}