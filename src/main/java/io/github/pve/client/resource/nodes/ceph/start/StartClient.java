package io.github.pve.client.resource.nodes.ceph.start;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/ceph/start
 * BY '@xiao-rao'
 */
public class StartClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public StartClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/ceph/start".replace("{" + "node" + "}", node);
    }

    /**
     * Start ceph services.
     */
    public String start(String service) {
        Map<String, Object> options = new HashMap<>();
        if (service != null) {
            options.put("service", service);
        }
        PveResponse<String> response = executor.post(this.basePath, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}