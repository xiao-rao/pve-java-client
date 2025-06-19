package io.github.pve.client.resource.access.users.tfa;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.access.users.tfa.*;

/**
 * Client for /access/users/{userid}/tfa
 * BY '@xiao-rao'
 */
public class TfaClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String userId;

    public TfaClient(ProxmoxApiExecutor executor, String userId) {
        this.executor = executor;
        this.userId = userId;
        this.basePath = "/access/users/{userid}/tfa".replace("{userid}", userId);
    }

    /**
     * Get user TFA types (Personal and Realm).
     */
    public ReadUserTfaTypeResponse readUserTfaType(Boolean multiple) {
        Map<String, Object> queryParams = new HashMap<>();
        if (multiple != null) {
            queryParams.put("multiple", multiple);
        }
        PveResponse<ReadUserTfaTypeResponse> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}