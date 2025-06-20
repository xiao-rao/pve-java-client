package io.github.pve.client.resource.storage;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.storage.*;

/**
 * Client for /storage
 * BY '@xiao-rao'
 */
public class StorageClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public StorageClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/storage";
    }

    /**
     * Storage index.
     */
    public List<StorageIndexResponse> index(String type) {
        Map<String, Object> queryParams = new HashMap<>();
        if (type != null) {
            queryParams.put("type", type);
        }
        PveResponse<List<StorageIndexResponse>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create a new storage.
     */
    public CreateResponse create(CreateRequest request) {
        PveResponse<CreateResponse> response = executor.post(this.basePath, request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Delete storage configuration.
     */
    public void delete(String storage) {
        executor.delete(this.basePath + "/" + storage);
    }

    /**
     * Read storage configuration.
     */
    public Map<String, Object> read(String storage) {
        PveResponse<Map<String, Object>> response = executor.get(this.basePath + "/" + storage, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Update storage configuration.
     */
    public UpdateResponse update(UpdateRequest request) {
        PveResponse<UpdateResponse> response = executor.put(this.basePath + "/" + request.getStorage(), request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}