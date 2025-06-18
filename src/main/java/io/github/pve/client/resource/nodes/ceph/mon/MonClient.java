package io.github.pve.client.resource.nodes.ceph.mon;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.ceph.mon.*;

/**
 * Client for /nodes/{node}/ceph/mon
 * BY '@xiao-rao'
 */
public class MonClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public MonClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/ceph/mon".replace("{" + "node" + "}", node);
    }

    /**
     * Get Ceph monitor list.
     */
    public List<ListmonResponse> listmon() {
        PveResponse<List<ListmonResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Destroy Ceph Monitor and Manager.
     */
    public String destroymon(String monId) {
        PveResponse<String> response = executor.delete(this.basePath + "/" + monId, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create Ceph Monitor and Manager
     */
    public String createmon(String monId, String monAddress) {
        String path = this.basePath + "/" + monId;
        Map<String, Object> options = new HashMap<>();
        if (monAddress != null) {
            options.put("mon-address", monAddress);
        }
        PveResponse<String> response = executor.post(path, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}