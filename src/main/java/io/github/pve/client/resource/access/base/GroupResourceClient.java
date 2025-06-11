package io.github.pve.client.resource.access.base;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.exception.ProxmoxApiException;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import io.github.pve.client.model.access.Group;
import io.github.pve.client.model.access.options.GroupCreationOrUpdateOptions;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理用户组 (Groups) - /access/groups
 */
public class GroupResourceClient {

    private final ProxmoxApiExecutor executor;

    public GroupResourceClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
    }

    public List<Group> list() {
        PveResponse<List<Group>> response = executor.get("/access/groups", null, new TypeReference<>() {
        });
        return response.getData().orElse(Collections.emptyList());
    }

    public void create(String groupId, GroupCreationOrUpdateOptions options) {
        String path = "/access/groups";
        Map<String, Object> params = options != null ? ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {
        }) : new HashMap<>();
        params.put("groupid", groupId);
        executor.post(path, null, params, new TypeReference<Void>() {
        });
    }

    public Group get(String groupId) {
        String path = "/access/groups/" + groupId;
        PveResponse<Group> response = executor.get(path, null, new TypeReference<>() {
        });
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Get Group data is null", response.getStatusCode(), null, null, path));
    }

    public void update(String groupId, GroupCreationOrUpdateOptions options) {
        String path = "/access/groups/" + groupId;
        Map<String, Object> params = ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {
        });
        executor.put(path, null, params, new TypeReference<Void>() {
        });
    }

    public void delete(String groupId) {
        String path = "/access/groups/" + groupId;
        executor.delete(path, null, null, new TypeReference<Void>() {
        });
    }
}
