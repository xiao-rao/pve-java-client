package io.github.pve.client.resource.nodes.qemu.firewall.log;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.qemu.firewall.log.*;

/**
 * Client for /nodes/{node}/qemu/{vmid}/firewall/log
 * BY '@xiao-rao'
 */
public class LogClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public LogClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/qemu/{vmid}/firewall/log".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmId);
    }

    /**
     * Read firewall log
     */
    public List<LogResponse> log(Integer limit, Integer since, Integer start, Integer until) {
        Map<String, Object> queryParams = new HashMap<>();
        if (limit != null) {
            queryParams.put("limit", limit);
        }
        if (since != null) {
            queryParams.put("since", since);
        }
        if (start != null) {
            queryParams.put("start", start);
        }
        if (until != null) {
            queryParams.put("until", until);
        }
        PveResponse<List<LogResponse>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}