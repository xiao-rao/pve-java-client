package io.github.pve.client.resource.cluster.ha.groups;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.ha.groups.*;

/**
 * Client for /cluster/ha/groups
 * BY '@xiao-rao'
 */
public class GroupsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public GroupsClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/ha/groups";
    }

    /**
     * Get HA groups.
     */
    public List<HaGroupsIndexResponse> index() {
        PveResponse<List<HaGroupsIndexResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create a new HA group.
     */
    public void create(CreateRequest request) {
        executor.post(this.basePath, request);
    }

    /**
     * Delete ha group configuration.
     */
    public void delete(String group) {
        executor.delete(this.basePath + "/" + group);
    }

    /**
     * Read ha group configuration.
     */
    public void read(String group) {
        executor.get(this.basePath + "/" + group);
    }

    /**
     * Update ha group configuration.
     */
    public void update(UpdateRequest request) {
        executor.put(this.basePath + "/" + request.getGroup(), request);
    }
}