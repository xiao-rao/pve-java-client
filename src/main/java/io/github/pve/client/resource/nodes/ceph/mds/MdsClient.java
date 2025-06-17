package io.github.pve.client.resource.nodes.ceph.mds;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.ceph.mds.*;

/**
 * Client for /nodes/{node}/ceph/mds
 * BY '@xiao-rao'
 */
public class MdsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public MdsClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/ceph/mds".replace("{" + "node" + "}", node);
    }

    /**
     * MDS directory index.
     */
    public IndexResponse index() {
        PveResponse<IndexResponse> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Destroy Ceph Metadata Server
     */
    public void destroymds(String name) {
        executor.delete(this.basePath + "/" + name);
    }

    /**
     * Create Ceph Metadata Server (MDS)
     */
    public void createmds(String name, Boolean hotstandby) {
        String path = this.basePath + "/" + name;
        Map<String, Object> options = new HashMap<>();
        if (hotstandby != null) {
            options.put("hotstandby", hotstandby);
        }
        executor.post(path, options);
    }
}