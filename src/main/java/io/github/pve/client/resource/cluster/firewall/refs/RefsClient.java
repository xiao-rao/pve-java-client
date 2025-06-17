package io.github.pve.client.resource.cluster.firewall.refs;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.firewall.refs.*;

/**
 * Client for /cluster/firewall/refs
 * BY '@xiao-rao'
 */
public class RefsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public RefsClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/firewall/refs";
    }

    /**
     * Lists possible IPSet/Alias reference which are allowed in source/dest properties.
     */
    public RefsResponse refs(String type) {
        Map<String, Object> queryParams = new HashMap<>();
        if (type != null) {
            queryParams.put("type", type);
        }
        PveResponse<RefsResponse> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}