package io.github.pve.client.resource.cluster.ha.resources.relocate;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /cluster/ha/resources/{sid}/relocate
 * BY '@xiao-rao'
 */
public class RelocateClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String sid;

    public RelocateClient(ProxmoxApiExecutor executor, String sid) {
        this.executor = executor;
        this.sid = sid;
        this.basePath = "/cluster/ha/resources/{sid}/relocate".replace("{" + "sid" + "}", sid);
    }

    /**
     * Request resource relocatzion to another node. This stops the service on the old node, and restarts it on the target node.
     */
    public void relocate(String node) {
        executor.post(this.basePath + "/" + node);
    }
}