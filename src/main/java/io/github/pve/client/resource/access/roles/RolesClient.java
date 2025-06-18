package io.github.pve.client.resource.access.roles;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.access.roles.*;

/**
 * Client for /access/roles
 * BY '@xiao-rao'
 */
public class RolesClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public RolesClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/access/roles";
    }

    /**
     * Role index.
     */
    public List<AccessRolesIndexResponse> index() {
        PveResponse<List<AccessRolesIndexResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create new role.
     */
    public void createRole(String privs, String roleId) {
        Map<String, Object> options = new HashMap<>();
        if (privs != null) {
            options.put("privs", privs);
        }
        if (roleId != null) {
            options.put("roleid", roleId);
        }
        executor.post(this.basePath, options);
    }

    /**
     * Delete role.
     */
    public void deleteRole(String roleId) {
        executor.delete(this.basePath + "/" + roleId);
    }

    /**
     * Get role configuration.
     */
    public ReadRoleResponse readRole(String roleId) {
        PveResponse<ReadRoleResponse> response = executor.get(this.basePath + "/" + roleId, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Update an existing role.
     */
    public void updateRole(String roleId, Boolean append, String privs) {
        String path = this.basePath + "/" + roleId;
        Map<String, Object> options = new HashMap<>();
        if (append != null) {
            options.put("append", append);
        }
        if (privs != null) {
            options.put("privs", privs);
        }
        executor.put(path, options);
    }
}