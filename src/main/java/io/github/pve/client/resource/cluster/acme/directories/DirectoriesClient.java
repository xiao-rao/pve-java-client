package io.github.pve.client.resource.cluster.acme.directories;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.acme.directories.*;

/**
 * Client for /cluster/acme/directories
 * BY '@xiao-rao'
 */
public class DirectoriesClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public DirectoriesClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/acme/directories";
    }

    /**
     * Get named known ACME directory endpoints.
     */
    public List<GetDirectoriesResponse> getDirectories() {
        PveResponse<List<GetDirectoriesResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}