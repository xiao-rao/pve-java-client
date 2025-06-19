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
        this.basePath = "/nodes/{node}/ceph/mds".replace("{node}", node);
    }

    /**
     * MDS directory index.
     */
    public List<CephMdsIndexResponse> index() {
        PveResponse<List<CephMdsIndexResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Destroy Ceph Metadata Server
     */
    public String destroymds(String name) {
        PveResponse<String> response = executor.delete(this.basePath + "/" + name, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create Ceph Metadata Server (MDS)
     */
    public String createmds(String name, Boolean hotstandby) {
        String path = this.basePath + "/" + name;
        Map<String, Object> options = new HashMap<>();
        if (hotstandby != null) {
            options.put("hotstandby", hotstandby);
        }
        PveResponse<String> response = executor.post(path, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}