package io.github.pve.client.resource.cluster.ha.resources.migrate;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /cluster/ha/resources/{sid}/migrate
 * BY '@xiao-rao'
 */
public class MigrateClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String sId;

    public MigrateClient(ProxmoxApiExecutor executor, String sId) {
        this.executor = executor;
        this.sId = sId;
        this.basePath = "/cluster/ha/resources/{sid}/migrate".replace("{" + "sid" + "}", sId);
    }

    /**
     * Request resource migration (online) to another node.
     */
    public void migrate(String node) {
        executor.post(this.basePath + "/" + node);
    }
}