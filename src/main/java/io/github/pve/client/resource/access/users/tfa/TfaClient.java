package io.github.pve.client.resource.access.users.tfa;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /access/users/{userid}/tfa
 * BY '@xiao-rao'
 */
public class TfaClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String userid;

    public TfaClient(ProxmoxApiExecutor executor, String userid) {
        this.executor = executor;
        this.userid = userid;
        this.basePath = "/access/users/{userid}/tfa".replace("{" + "userid" + "}", userid);
    }

    /**
     * Get user TFA types (Personal and Realm).
     */
    public Object readUserTfaType(Boolean multiple) {
        Map<String, Object> queryParams = new HashMap<>();
        if (multiple != null) {
            queryParams.put("multiple", multiple);
        }
        PveResponse<Object> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}