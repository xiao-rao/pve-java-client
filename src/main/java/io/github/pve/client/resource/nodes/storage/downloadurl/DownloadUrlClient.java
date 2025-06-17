package io.github.pve.client.resource.nodes.storage.downloadurl;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.storage.downloadurl.*;

/**
 * Client for /nodes/{node}/storage/{storage}/download-url
 * BY '@xiao-rao'
 */
public class DownloadUrlClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String storage;

    public DownloadUrlClient(ProxmoxApiExecutor executor, String node, String storage) {
        this.executor = executor;
        this.node = node;
        this.storage = storage;
        this.basePath = "/nodes/{node}/storage/{storage}/download-url".replace("{" + "node" + "}", node).replace("{" + "storage" + "}", storage);
    }

    /**
     * Download templates, ISO images, OVAs and VM images by using an URL.
     */
    public String downloadUrl(DownloadUrlRequest request) {
        PveResponse<String> response = executor.post(this.basePath, request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}