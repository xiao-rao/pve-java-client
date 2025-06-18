package io.github.pve.client.resource.cluster.ha.status.manager_status;

import java.util.Map;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /cluster/ha/status/manager_status
 * BY '@xiao-rao'
 */
public class ManagerStatusClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public ManagerStatusClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/ha/status/manager_status";
    }

    /**
     * Get full HA manger status, including LRM status.
     */
    public Map<String, Object> managerStatus() {
        PveResponse<Map<String, Object>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}