package io.github.pve.client.resource.nodes.storage.upload;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.storage.upload.*;

/**
 * Client for /nodes/{node}/storage/{storage}/upload
 * BY '@xiao-rao'
 */
public class UploadClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String storage;

    public UploadClient(ProxmoxApiExecutor executor, String node, String storage) {
        this.executor = executor;
        this.node = node;
        this.storage = storage;
        this.basePath = "/nodes/{node}/storage/{storage}/upload".replace("{node}", node).replace("{storage}", storage);
    }

    /**
     * Upload templates, ISO images, OVAs and VM images.
     */
    public String upload(UploadRequest request) {
        PveResponse<String> response = executor.post(this.basePath, request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}