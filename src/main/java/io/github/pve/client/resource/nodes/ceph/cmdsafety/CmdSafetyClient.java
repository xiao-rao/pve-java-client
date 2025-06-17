package io.github.pve.client.resource.nodes.ceph.cmdsafety;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/ceph/cmd-safety
 * BY '@xiao-rao'
 */
public class CmdSafetyClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public CmdSafetyClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/ceph/cmd-safety".replace("{" + "node" + "}", node);
    }

    /**
     * Heuristical check if it is safe to perform an action.
     */
    public Object cmdSafety(String id, String action, String service) {
        String path = this.basePath + "/" + id;
        Map<String, Object> queryParams = new HashMap<>();
        if (action != null) {
            queryParams.put("action", action);
        }
        if (service != null) {
            queryParams.put("service", service);
        }
        PveResponse<Object> response = executor.get(path, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}