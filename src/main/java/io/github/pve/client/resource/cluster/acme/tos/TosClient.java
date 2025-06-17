package io.github.pve.client.resource.cluster.acme.tos;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /cluster/acme/tos
 * BY '@xiao-rao'
 */
public class TosClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public TosClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/acme/tos";
    }

    /**
     * Retrieve ACME TermsOfService URL from CA. Deprecated, please use /cluster/acme/meta.
     */
    public String getTos(String directory) {
        Map<String, Object> queryParams = new HashMap<>();
        if (directory != null) {
            queryParams.put("directory", directory);
        }
        PveResponse<String> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}