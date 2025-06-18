package io.github.pve.client.resource.nodes.apt.repositories;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.apt.repositories.*;

/**
 * Client for /nodes/{node}/apt/repositories
 * BY '@xiao-rao'
 */
public class RepositoriesClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public RepositoriesClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/apt/repositories".replace("{" + "node" + "}", node);
    }

    /**
     * Get APT repository information.
     */
    public RepositoriesResponse repositories() {
        PveResponse<RepositoriesResponse> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Change the properties of a repository. Currently only allows enabling/disabling.
     */
    public void changeRepository(ChangeRepositoryRequest request) {
        executor.post(this.basePath, request);
    }

    /**
     * Add a standard repository to the configuration
     */
    public void addRepository(String digest, String handle) {
        Map<String, Object> options = new HashMap<>();
        if (digest != null) {
            options.put("digest", digest);
        }
        if (handle != null) {
            options.put("handle", handle);
        }
        executor.put(this.basePath, options);
    }
}