package io.github.pve.client.resource.cluster.acme.meta;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.acme.meta.*;

/**
 * Client for /cluster/acme/meta
 * BY '@xiao-rao'
 */
public class MetaClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public MetaClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/acme/meta";
    }

    /**
     * Retrieve ACME Directory Meta Information
     */
    public GetMetaResponse getMeta(String directory) {
        Map<String, Object> queryParams = new HashMap<>();
        if (directory != null) {
            queryParams.put("directory", directory);
        }
        PveResponse<GetMetaResponse> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}