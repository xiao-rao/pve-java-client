package io.github.pve.client.resource.version;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.version.*;

/**
 * Client for /version
 * BY '@xiao-rao'
 */
public class VersionClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public VersionClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/version";
    }

    /**
     * API version details, including some parts of the global datacenter config.
     */
    public VersionResponse version() {
        PveResponse<VersionResponse> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}