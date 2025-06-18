package io.github.pve.client.resource.cluster.ha.status.current;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.ha.status.current.*;

/**
 * Client for /cluster/ha/status/current
 * BY '@xiao-rao'
 */
public class CurrentClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public CurrentClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/ha/status/current";
    }

    /**
     * Get HA manger status.
     */
    public List<StatusResponse> status() {
        PveResponse<List<StatusResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}