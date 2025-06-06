package io.github.pve.client.resource;

import io.github.pve.client.exception.ProxmoxApiException;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import io.github.pve.client.exception.ProxmoxAuthException;
import io.github.pve.client.model.pool.Pool;
import io.github.pve.client.model.pool.options.PoolUpdateOptions;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 资源池客户端。
 */
public class PoolResourceClient extends BaseResourceClient {
    public PoolResourceClient(ProxmoxApiExecutor executor) {
        super(executor);
    }

    /**
     * 列出所有资源池。
     */
    public List<Pool> listPools() throws ProxmoxApiException, ProxmoxAuthException {
        PveResponse<List<Pool>> response = executor.get("/pools", null, new TypeReference<>() {});
        return response.getData().orElse(Collections.emptyList());
    }

    /**
     * 获取指定资源池的详细信息。
     */
    public Pool getPool(String poolId) throws ProxmoxApiException, ProxmoxAuthException {
        String path = "/pools/" + poolId;
        PveResponse<Pool> response = executor.get(path, null, new TypeReference<>() {});
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Get Pool data is null", response.getStatusCode(), null, null, path));
    }

    /**
     * 创建一个新资源池。
     */
    public void createPool(String poolId, String comment) throws ProxmoxApiException, ProxmoxAuthException {
        String path = "/pools";
        Map<String, String> params = new HashMap<>();
        params.put("poolid", poolId);
        if (comment != null) {
            params.put("comment", comment);
        }
        executor.post(path, null, params, new TypeReference<Void>() {});
    }

    /**
     * 更新一个资源池（例如，修改评论，添加/删除成员）。
     */
    public void updatePool(String poolId, PoolUpdateOptions options) throws ProxmoxApiException, ProxmoxAuthException {
        String path = "/pools/" + poolId;
        Map<String, Object> params = ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {});
        executor.put(path, null, params, new TypeReference<Void>() {});
    }

    /**
     * 删除一个资源池。
     */
    public void deletePool(String poolId) throws ProxmoxApiException, ProxmoxAuthException {
        String path = "/pools/" + poolId;
        executor.delete(path, null, null, new TypeReference<Void>() {});
    }
}
