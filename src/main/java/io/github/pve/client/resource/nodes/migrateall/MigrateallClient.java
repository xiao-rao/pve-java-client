package io.github.pve.client.resource.nodes.migrateall;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.migrateall.*;

/**
 * Client for /nodes/{node}/migrateall
 * BY '@xiao-rao'
 */
public class MigrateallClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public MigrateallClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/migrateall".replace("{node}", node);
    }

    /**
     * Migrate all VMs and Containers.
     */
    public String migrateall(MigrateallRequest request) {
        PveResponse<String> response = executor.post(this.basePath, request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}