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
    public List<Object> index() {
        PveResponse<List<Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create new role.
     */
    public void createRole(String privs, String roleid) {
        Map<String, Object> options = new HashMap<>();
        if (privs != null) {
            options.put("privs", privs);
        }
        if (roleid != null) {
            options.put("roleid", roleid);
        }
        executor.post(this.basePath, options);
    }

    /**
     * Delete role.
     */
    public void deleteRole(String roleid) {
        executor.delete(this.basePath + "/" + roleid);
    }

    /**
     * Get role configuration.
     */
    public ReadRoleResponse readRole(String roleid) {
        PveResponse<ReadRoleResponse> response = executor.get(this.basePath + "/" + roleid, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Update an existing role.
     */
    public void updateRole(String roleid, Boolean append, String privs) {
        String path = this.basePath + "/" + roleid;
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