package io.github.pve.client.resource.nodes.lxc.firewall.refs;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.lxc.firewall.refs.*;

/**
 * Client for /nodes/{node}/lxc/{vmid}/firewall/refs
 * BY '@xiao-rao'
 */
public class RefsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public RefsClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/lxc/{vmid}/firewall/refs".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Lists possible IPSet/Alias reference which are allowed in source/dest properties.
     */
    public RefsResponse refs(String type) {
        Map<String, Object> queryParams = new HashMap<>();
        if (type != null) {
            queryParams.put("type", type);
        }
        PveResponse<RefsResponse> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}