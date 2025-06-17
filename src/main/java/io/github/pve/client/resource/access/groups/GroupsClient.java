package io.github.pve.client.resource.access.groups;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

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
    public List<Object> index() {
        PveResponse<List<Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create new group.
     */
    public void createGroup(String comment, String groupid) {
        Map<String, Object> options = new HashMap<>();
        if (comment != null) {
            options.put("comment", comment);
        }
        if (groupid != null) {
            options.put("groupid", groupid);
        }
        executor.post(this.basePath, options);
    }

    /**
     * Delete group.
     */
    public void deleteGroup(String groupid) {
        executor.delete(this.basePath + "/" + groupid);
    }

    /**
     * Get group configuration.
     */
    public void readGroup(String groupid) {
        executor.get(this.basePath + "/" + groupid);
    }

    /**
     * Update group data.
     */
    public void updateGroup(String groupid, String comment) {
        String path = this.basePath + "/" + groupid;
        Map<String, Object> options = new HashMap<>();
        if (comment != null) {
            options.put("comment", comment);
        }
        executor.put(path, options);
    }
}