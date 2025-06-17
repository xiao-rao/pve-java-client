package io.github.pve.client.resource.nodes.certificates.custom;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.certificates.custom.*;

/**
 * Client for /nodes/{node}/certificates/custom
 * BY '@xiao-rao'
 */
public class CustomClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public CustomClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/certificates/custom".replace("{" + "node" + "}", node);
    }

    /**
     * DELETE custom certificate chain and key.
     */
    public void removeCustomCert(Boolean restart) {
        Map<String, Object> options = new HashMap<>();
        if (restart != null) {
            options.put("restart", restart);
        }
        executor.delete(this.basePath, options);
    }

    /**
     * Upload or update custom certificate chain and key.
     */
    public UploadCustomCertResponse uploadCustomCert(UploadCustomCertRequest request) {
        PveResponse<UploadCustomCertResponse> response = executor.post(this.basePath, request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}