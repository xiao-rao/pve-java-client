package io.github.pve.client.resource.nodes.ceph.restart;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/ceph/restart
 * BY '@xiao-rao'
 */
public class RestartClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public RestartClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/ceph/restart".replace("{" + "node" + "}", node);
    }

    /**
     * Restart ceph services.
     */
    public String restart(String service) {
        Map<String, Object> options = new HashMap<>();
        if (service != null) {
            options.put("service", service);
        }
        PveResponse<String> response = executor.post(this.basePath, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}