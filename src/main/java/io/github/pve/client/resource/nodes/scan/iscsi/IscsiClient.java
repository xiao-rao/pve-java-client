package io.github.pve.client.resource.nodes.scan.iscsi;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/scan/iscsi
 * BY '@xiao-rao'
 */
public class IscsiClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public IscsiClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/scan/iscsi".replace("{" + "node" + "}", node);
    }

    /**
     * Scan remote iSCSI server.
     */
    public List<Object> iscsiscan(String portal) {
        Map<String, Object> queryParams = new HashMap<>();
        if (portal != null) {
            queryParams.put("portal", portal);
        }
        PveResponse<List<Object>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}