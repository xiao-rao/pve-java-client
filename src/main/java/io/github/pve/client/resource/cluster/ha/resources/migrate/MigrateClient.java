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
    protected final String sid;

    public MigrateClient(ProxmoxApiExecutor executor, String sid) {
        this.executor = executor;
        this.sid = sid;
        this.basePath = "/cluster/ha/resources/{sid}/migrate".replace("{" + "sid" + "}", sid);
    }

    /**
     * Request resource migration (online) to another node.
     */
    public void migrate(String node) {
        executor.post(this.basePath + "/" + node);
    }
}