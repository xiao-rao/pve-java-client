package io.github.pve.client.resource.access.tfa;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.access.tfa.*;

/**
 * Client for /access/tfa
 * BY '@xiao-rao'
 */
public class TfaClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public TfaClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/access/tfa";
    }

    /**
     * List TFA configurations of users.
     */
    public ListTfaResponse listTfa() {
        PveResponse<ListTfaResponse> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * List TFA configurations of users.
     */
    public ListUserTfaResponse listUserTfa(String userid) {
        PveResponse<ListUserTfaResponse> response = executor.get(this.basePath + "/" + userid, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Add a TFA entry for a user.
     */
    public void addTfaEntry(AddTfaEntryRequest request) {
        executor.post(this.basePath + "/" + request.getUserid(), request);
    }

    /**
     * Delete a TFA entry by ID.
     */
    public void deleteTfa(String id, String userid, String password) {
        String path = this.basePath + "/" + userid;
        path = path + "/" + id;
        Map<String, Object> options = new HashMap<>();
        if (password != null) {
            options.put("password", password);
        }
        executor.delete(path, options);
    }

    /**
     * Fetch a requested TFA entry if present.
     */
    public GetTfaEntryResponse getTfaEntry(String id, String userid) {
        PveResponse<GetTfaEntryResponse> response = executor.get(this.basePath + "/" + userid + "/" + id, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Add a TFA entry for a user.
     */
    public void updateTfaEntry(UpdateTfaEntryRequest request) {
        executor.put(this.basePath + "/" + request.getUserid() + "/" + request.getId(), request);
    }
}