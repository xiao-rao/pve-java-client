package io.github.pve.client.resource.nodes.scan.glusterfs;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/scan/glusterfs
 * BY '@xiao-rao'
 */
public class GlusterfsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public GlusterfsClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/scan/glusterfs".replace("{" + "node" + "}", node);
    }

    /**
     * Scan remote GlusterFS server.
     */
    public List<Object> glusterfsscan(String server) {
        Map<String, Object> queryParams = new HashMap<>();
        if (server != null) {
            queryParams.put("server", server);
        }
        PveResponse<List<Object>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}