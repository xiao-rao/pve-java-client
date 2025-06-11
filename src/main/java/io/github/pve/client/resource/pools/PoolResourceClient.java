package io.github.pve.client.resource.pools;

import io.github.pve.client.exception.ProxmoxApiException;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import io.github.pve.client.model.pool.Pool;
import io.github.pve.client.model.pool.options.PoolUpdateOptions;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.model.pool.options.PoolsBulkUpdateOrDeleteOptions;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理资源池 - /pools
 */
public class PoolResourceClient {
    private final ProxmoxApiExecutor executor;

    public PoolResourceClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
    }

    public List<Pool> list() {
        PveResponse<List<Pool>> response = executor.get("/pools", null, new TypeReference<>() {
        });
        return response.getData().orElse(Collections.emptyList());
    }

    public void create(String poolId, String comment) {
        Map<String, String> params = new HashMap<>();
        params.put("poolid", poolId);
        if (comment != null && !comment.isEmpty()) {
            params.put("comment", comment);
        }
        executor.post("/pools", null, params, new TypeReference<Void>() {
        });
    }

    public void updateAll(PoolsBulkUpdateOrDeleteOptions options) {
        Map<String, Object> params = ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {
        });
        executor.put("/pools", null, params, new TypeReference<Void>() {
        });
    }

    public void deleteAll(PoolsBulkUpdateOrDeleteOptions options) {
        Map<String, Object> params = ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {
        });
        executor.delete("/pools", null, params, new TypeReference<Void>() {
        });
    }


    public Pool get(String poolId, Boolean listVms) {
        String path = "/pools/" + poolId;
        Map<String, String> params = null;
        if (listVms != null) {
            params = new HashMap<>();
            params.put("vms", listVms ? "1" : "0");
        }
        PveResponse<Pool> response = executor.get(path, params, new TypeReference<>() {
        });
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Get Pool data is null", response.getStatusCode(), null, null, path));
    }

    public Pool get(String poolId) {
        return get(poolId, null);
    }

    public void update(String poolId, PoolUpdateOptions options) {
        Map<String, Object> params = ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {
        });
        executor.put("/pools/" + poolId, null, params, new TypeReference<Void>() {
        });
    }

    public void delete(String poolId) {
        executor.delete("/pools/" + poolId, null, null, new TypeReference<Void>() {
        });
    }
}
