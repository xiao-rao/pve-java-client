package io.github.pve.client.resource.nodes.scan.nfs;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.scan.nfs.*;

/**
 * Client for /nodes/{node}/scan/nfs
 * BY '@xiao-rao'
 */
public class NfsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public NfsClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/scan/nfs".replace("{" + "node" + "}", node);
    }

    /**
     * Scan remote NFS server.
     */
    public List<NfsscanResponse> nfsscan(String server) {
        Map<String, Object> queryParams = new HashMap<>();
        if (server != null) {
            queryParams.put("server", server);
        }
        PveResponse<List<NfsscanResponse>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}