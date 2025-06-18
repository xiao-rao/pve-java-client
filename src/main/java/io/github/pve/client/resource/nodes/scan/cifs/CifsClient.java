package io.github.pve.client.resource.nodes.scan.cifs;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.scan.cifs.*;

/**
 * Client for /nodes/{node}/scan/cifs
 * BY '@xiao-rao'
 */
public class CifsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public CifsClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/scan/cifs".replace("{" + "node" + "}", node);
    }

    /**
     * Scan remote CIFS server.
     */
    public List<CifsscanResponse> cifsscan(String domain, String password, String server, String username) {
        Map<String, Object> queryParams = new HashMap<>();
        if (domain != null) {
            queryParams.put("domain", domain);
        }
        if (password != null) {
            queryParams.put("password", password);
        }
        if (server != null) {
            queryParams.put("server", server);
        }
        if (username != null) {
            queryParams.put("username", username);
        }
        PveResponse<List<CifsscanResponse>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}