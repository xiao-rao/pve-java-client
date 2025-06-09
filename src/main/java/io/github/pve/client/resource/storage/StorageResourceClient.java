package io.github.pve.client.resource.storage;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.exception.ProxmoxApiException;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import io.github.pve.client.model.storage.StorageSummary;
import io.github.pve.client.model.storage.options.StorageCreationOrUpdateOptions;
import io.github.pve.client.resource.BaseResourceClient;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理存储配置 - /storage
 */
public class StorageResourceClient extends BaseResourceClient {

    public StorageResourceClient(ProxmoxApiExecutor executor) {
        super(executor);
    }

    /**
     * 列出所有存储 (完整参数)。
     * @param typeFilter 仅返回指定类型的存储
     * @param contentFilter 仅返回包含指定内容的存储
     * @param enabledOnly 仅返回启用的存储
     * @return 存储摘要列表
     */
    public List<StorageSummary> list(String typeFilter, String contentFilter, Boolean enabledOnly)   {
        Map<String, String> params = new HashMap<>();
        if (typeFilter != null) params.put("type", typeFilter);
        if (contentFilter != null) params.put("content", contentFilter);
        if (enabledOnly != null) params.put("enabled", enabledOnly ? "1" : "0");
        PveResponse<List<StorageSummary>> response = executor.get("/storage", params.isEmpty() ? null : params, new TypeReference<>() {});
        return response.getData().orElse(Collections.emptyList());
    }

    /**
     * 列出所有存储 (无参数)。
     */
    public List<StorageSummary> list()   {
        return list(null, null, null);
    }

    public void create(String storageId, String type, StorageCreationOrUpdateOptions options)   {
        Map<String, Object> params = ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {});
        params.put("storage", storageId);
        params.put("type", type); // 'type' is a required parameter for creation
        executor.post("/storage", null, params, new TypeReference<Void>() {});
    }

    public StorageSummary get(String storageId)   {
        String path = "/storage/" + storageId;
        PveResponse<StorageSummary> response = executor.get(path, null, new TypeReference<>() {});
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Get Storage data is null", response.getStatusCode(), null, null, path));
    }

    public void update(String storageId, StorageCreationOrUpdateOptions options)   {
        Map<String, Object> params = ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {});
        executor.put("/storage/" + storageId, null, params, new TypeReference<Void>() {});
    }

    public void delete(String storageId)   {
        executor.delete("/storage/" + storageId, null, null, new TypeReference<Void>() {});
    }
}
