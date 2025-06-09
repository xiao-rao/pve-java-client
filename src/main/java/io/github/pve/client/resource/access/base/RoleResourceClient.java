package io.github.pve.client.resource.access.base;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.exception.ProxmoxApiException;
import io.github.pve.client.exception.ProxmoxAuthException;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import io.github.pve.client.model.access.Role;
import io.github.pve.client.resource.BaseResourceClient;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理角色 (Roles) - /access/roles
 */
public class RoleResourceClient extends BaseResourceClient {

    public RoleResourceClient(ProxmoxApiExecutor executor) {
        super(executor);
    }

    public List<Role> list() throws ProxmoxApiException, ProxmoxAuthException {
        PveResponse<List<Role>> response = executor.get("/access/roles", null, new TypeReference<>() {});
        return response.getData().orElse(Collections.emptyList());
    }

    public void create(String roleId, String privileges) throws ProxmoxApiException, ProxmoxAuthException {
        String path = "/access/roles";
        Map<String, Object> params = new HashMap<>();
        params.put("roleid", roleId);
        params.put("privs", privileges);
        executor.post(path, null, params, new TypeReference<Void>() {});
    }

    public Role get(String roleId) throws ProxmoxApiException, ProxmoxAuthException {
        String path = "/access/roles/" + roleId;
        PveResponse<Role> response = executor.get(path, null, new TypeReference<>() {});
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Get Role data is null", response.getStatusCode(), null, null, path));
    }

    public void update(String roleId, String privileges, Boolean append) throws ProxmoxApiException, ProxmoxAuthException {
        String path = "/access/roles/" + roleId;
        Map<String, Object> params = new HashMap<>();
        params.put("privs", privileges);
        if (append != null) {
            params.put("append", append ? "1" : "0");
        }
        executor.put(path, null, params, new TypeReference<Void>() {});
    }

    public void delete(String roleId) throws ProxmoxApiException, ProxmoxAuthException {
        String path = "/access/roles/" + roleId;
        executor.delete(path, null, null, new TypeReference<Void>() {});
    }
}
