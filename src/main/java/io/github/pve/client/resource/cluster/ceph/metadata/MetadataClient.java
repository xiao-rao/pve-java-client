package io.github.pve.client.resource.cluster.ceph.metadata;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.ceph.metadata.*;

/**
 * Client for /cluster/ceph/metadata
 * BY '@xiao-rao'
 */
public class MetadataClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public MetadataClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/ceph/metadata";
    }

    /**
     * Get ceph metadata.
     */
    public MetadataResponse metadata(String scope) {
        Map<String, Object> queryParams = new HashMap<>();
        if (scope != null) {
            queryParams.put("scope", scope);
        }
        PveResponse<MetadataResponse> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}