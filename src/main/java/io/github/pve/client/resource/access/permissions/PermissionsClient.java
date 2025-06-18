package io.github.pve.client.resource.access.permissions;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /access/permissions
 * BY '@xiao-rao'
 */
public class PermissionsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public PermissionsClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/access/permissions";
    }

    /**
     * Retrieve effective permissions of given user/token.
     */
    public Map<String, Object> permissions(String path, String userId) {
        Map<String, Object> queryParams = new HashMap<>();
        if (path != null) {
            queryParams.put("path", path);
        }
        if (userId != null) {
            queryParams.put("userid", userId);
        }
        PveResponse<Map<String, Object>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}