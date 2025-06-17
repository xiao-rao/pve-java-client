package io.github.pve.client.resource.nodes.ceph.init;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.ceph.init.*;

/**
 * Client for /nodes/{node}/ceph/init
 * BY '@xiao-rao'
 */
public class InitClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public InitClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/ceph/init".replace("{" + "node" + "}", node);
    }

    /**
     * Create initial ceph default configuration and setup symlinks.
     */
    public void init(InitRequest request) {
        executor.post(this.basePath, request);
    }
}