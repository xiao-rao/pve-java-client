package io.github.pve.client.resource.nodes.ceph.mgr;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.ceph.mgr.*;

/**
 * Client for /nodes/{node}/ceph/mgr
 * BY '@xiao-rao'
 */
public class MgrClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public MgrClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/ceph/mgr".replace("{" + "node" + "}", node);
    }

    /**
     * MGR directory index.
     */
    public IndexResponse index() {
        PveResponse<IndexResponse> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Destroy Ceph Manager.
     */
    public void destroymgr(String id) {
        executor.delete(this.basePath + "/" + id);
    }

    /**
     * Create Ceph Manager
     */
    public void createmgr(String id) {
        executor.post(this.basePath + "/" + id);
    }
}