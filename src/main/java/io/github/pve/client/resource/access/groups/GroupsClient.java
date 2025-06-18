package io.github.pve.client.resource.access.groups;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.access.groups.*;

/**
 * Client for /access/groups
 * BY '@xiao-rao'
 */
public class GroupsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public GroupsClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/access/groups";
    }

    /**
     * Group index.
     */
    public List<AccessGroupsIndexResponse> index() {
        PveResponse<List<AccessGroupsIndexResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create new group.
     */
    public void createGroup(String comment, String groupId) {
        Map<String, Object> options = new HashMap<>();
        if (comment != null) {
            options.put("comment", comment);
        }
        if (groupId != null) {
            options.put("groupid", groupId);
        }
        executor.post(this.basePath, options);
    }

    /**
     * Delete group.
     */
    public void deleteGroup(String groupId) {
        executor.delete(this.basePath + "/" + groupId);
    }

    /**
     * Get group configuration.
     */
    public ReadGroupResponse readGroup(String groupId) {
        PveResponse<ReadGroupResponse> response = executor.get(this.basePath + "/" + groupId, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Update group data.
     */
    public void updateGroup(String groupId, String comment) {
        String path = this.basePath + "/" + groupId;
        Map<String, Object> options = new HashMap<>();
        if (comment != null) {
            options.put("comment", comment);
        }
        executor.put(path, options);
    }
}