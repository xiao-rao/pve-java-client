package io.github.pve.client.resource.cluster.config.apiversion;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /cluster/config/apiversion
 * BY '@xiao-rao'
 */
public class ApiversionClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public ApiversionClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/config/apiversion";
    }

    /**
     * Return the version of the cluster join API available on this node.
     */
    public Integer joinApiVersion() {
        PveResponse<Integer> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}