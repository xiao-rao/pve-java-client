package io.github.pve.client.resource.cluster.ha;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.cluster.ha.resources.ResourcesClient;
import io.github.pve.client.resource.cluster.ha.groups.GroupsClient;
import io.github.pve.client.resource.cluster.ha.status.StatusClient;
// Import models if needed
import io.github.pve.client.model.cluster.ha.*;

/**
 * Client for /cluster/ha
 * BY '@xiao-rao'
 */
public class HaClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public HaClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/ha";
    }

    /**
     * Directory index.
     */
    public List<ClusterHaIndexResponse> index() {
        PveResponse<List<ClusterHaIndexResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `resources`
     */
    public ResourcesClient resources() {
        return new ResourcesClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `groups`
     */
    public GroupsClient groups() {
        return new GroupsClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `status`
     */
    public StatusClient status() {
        return new StatusClient(this.executor);
    }
}