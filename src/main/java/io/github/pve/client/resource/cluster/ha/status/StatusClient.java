package io.github.pve.client.resource.cluster.ha.status;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.cluster.ha.status.current.CurrentClient;
import io.github.pve.client.resource.cluster.ha.status.manager_status.ManagerStatusClient;

/**
 * Client for /cluster/ha/status
 * BY '@xiao-rao'
 */
public class StatusClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public StatusClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/ha/status";
    }

    /**
     * Directory index.
     */
    public List<Object> index() {
        PveResponse<List<Object>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `current`
     */
    public CurrentClient current() {
        return new CurrentClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `managerStatus`
     */
    public ManagerStatusClient managerStatus() {
        return new ManagerStatusClient(this.executor);
    }
}