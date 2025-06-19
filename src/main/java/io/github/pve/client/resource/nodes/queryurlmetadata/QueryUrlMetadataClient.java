package io.github.pve.client.resource.nodes.queryurlmetadata;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.queryurlmetadata.*;

/**
 * Client for /nodes/{node}/query-url-metadata
 * BY '@xiao-rao'
 */
public class QueryUrlMetadataClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public QueryUrlMetadataClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/query-url-metadata".replace("{node}", node);
    }

    /**
     * Query metadata of an URL: file size, file name and mime type.
     */
    public QueryUrlMetadataResponse queryUrlMetadata(String url, Boolean verifyCertificates) {
        Map<String, Object> queryParams = new HashMap<>();
        if (url != null) {
            queryParams.put("url", url);
        }
        if (verifyCertificates != null) {
            queryParams.put("verify-certificates", verifyCertificates);
        }
        PveResponse<QueryUrlMetadataResponse> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}