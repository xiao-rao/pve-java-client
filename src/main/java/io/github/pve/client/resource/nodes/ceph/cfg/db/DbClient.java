package io.github.pve.client.resource.nodes.ceph.cfg.db;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.ceph.cfg.db.*;

/**
 * Client for /nodes/{node}/ceph/cfg/db
 * BY '@xiao-rao'
 */
public class DbClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public DbClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/ceph/cfg/db".replace("{" + "node" + "}", node);
    }

    /**
     * Get the Ceph configuration database.
     */
    public DbResponse db() {
        PveResponse<DbResponse> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}