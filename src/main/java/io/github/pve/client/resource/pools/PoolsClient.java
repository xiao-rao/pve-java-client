package io.github.pve.client.resource.pools;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.pools.*;

/**
 * Client for /pools
 * BY '@xiao-rao'
 */
public class PoolsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public PoolsClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/pools";
    }

    /**
     * Delete pool.
     */
    public void deletePool(String poolId) {
        Map<String, Object> options = new HashMap<>();
        if (poolId != null) {
            options.put("poolid", poolId);
        }
        executor.delete(this.basePath, options);
    }

    /**
     * List pools or get pool configuration.
     */
    public List<PoolsIndexResponse> index(String poolId, String type) {
        Map<String, Object> queryParams = new HashMap<>();
        if (poolId != null) {
            queryParams.put("poolid", poolId);
        }
        if (type != null) {
            queryParams.put("type", type);
        }
        PveResponse<List<PoolsIndexResponse>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create new pool.
     */
    public void createPool(String comment, String poolId) {
        Map<String, Object> options = new HashMap<>();
        if (comment != null) {
            options.put("comment", comment);
        }
        if (poolId != null) {
            options.put("poolid", poolId);
        }
        executor.post(this.basePath, options);
    }

    /**
     * Update pool.
     */
    public void updatePool(UpdatePoolRequest request) {
        executor.put(this.basePath, request);
    }

    /**
     * Delete pool (deprecated, no support for nested pools, use 'DELETE /pools/?poolid={poolid}').
     */
    public void deletePoolDeprecated(String poolId) {
        executor.delete(this.basePath + "/" + poolId);
    }

    /**
     * Get pool configuration (deprecated, no support for nested pools, use 'GET /pools/?poolid={poolid}').
     */
    public ReadPoolResponse readPool(String poolId, String type) {
        String path = this.basePath + "/" + poolId;
        Map<String, Object> queryParams = new HashMap<>();
        if (type != null) {
            queryParams.put("type", type);
        }
        PveResponse<ReadPoolResponse> response = executor.get(path, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Update pool data (deprecated, no support for nested pools - use 'PUT /pools/?poolid={poolid}' instead).
     */
    public void updatePoolDeprecated(UpdatePoolDeprecatedRequest request) {
        executor.put(this.basePath + "/" + request.getPoolId(), request);
    }
}