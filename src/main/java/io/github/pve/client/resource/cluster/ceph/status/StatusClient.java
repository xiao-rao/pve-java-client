package io.github.pve.client.resource.cluster.ceph.status;

import java.util.Map;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /cluster/ceph/status
 * BY '@xiao-rao'
 */
public class StatusClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public StatusClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/ceph/status";
    }

    /**
     * Get ceph status.
     */
    public Map<String, Object> status() {
        PveResponse<Map<String, Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}