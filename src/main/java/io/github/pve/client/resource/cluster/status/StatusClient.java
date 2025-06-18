package io.github.pve.client.resource.cluster.status;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.status.*;

/**
 * Client for /cluster/status
 * BY '@xiao-rao'
 */
public class StatusClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public StatusClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/status";
    }

    /**
     * Get cluster status information.
     */
    public List<GetStatusResponse> getStatus() {
        PveResponse<List<GetStatusResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}