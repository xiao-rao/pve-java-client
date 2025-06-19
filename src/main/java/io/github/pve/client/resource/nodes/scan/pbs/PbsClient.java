package io.github.pve.client.resource.nodes.scan.pbs;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.scan.pbs.*;

/**
 * Client for /nodes/{node}/scan/pbs
 * BY '@xiao-rao'
 */
public class PbsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public PbsClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/scan/pbs".replace("{node}", node);
    }

    /**
     * Scan remote Proxmox Backup Server.
     */
    public List<PbsscanResponse> pbsscan(String fingerprint, String password, Integer port, String server, String username) {
        Map<String, Object> queryParams = new HashMap<>();
        if (fingerprint != null) {
            queryParams.put("fingerprint", fingerprint);
        }
        if (password != null) {
            queryParams.put("password", password);
        }
        if (port != null) {
            queryParams.put("port", port);
        }
        if (server != null) {
            queryParams.put("server", server);
        }
        if (username != null) {
            queryParams.put("username", username);
        }
        PveResponse<List<PbsscanResponse>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}