package io.github.pve.client.resource.access.base;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.exception.ProxmoxApiException;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import io.github.pve.client.model.access.Permissions;
import io.github.pve.client.resource.BaseResourceClient;

import java.util.HashMap;
import java.util.Map;

/**
 * 查询权限 - /access/permissions
 */
public class PermissionsResourceClient extends BaseResourceClient {

    public PermissionsResourceClient(ProxmoxApiExecutor executor) {
        super(executor);
    }

    public Permissions get(String userId, String path, boolean checkAll)   {
        String apiPath = "/access/permissions";
        Map<String, String> params = new HashMap<>();
        params.put("userid", userId);
        if (path != null) {
            params.put("path", path);
        }
        params.put("check-all", checkAll ? "1" : "0");

        // The response is a map, not wrapped in "data"
        PveResponse<Map<String, Boolean>> response = executor.get(apiPath, params, new TypeReference<>() {});
        Permissions permissions = new Permissions();
        permissions.setPrivileges(response.getData().orElseThrow(() -> new ProxmoxApiException("Get Permissions data is null", response.getStatusCode(), null, userId, apiPath)));
        return permissions;
    }
}

