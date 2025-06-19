package io.github.pve.client.resource.nodes.lxc.spiceproxy;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/lxc/{vmid}/spiceproxy
 * BY '@xiao-rao'
 */
public class SpiceproxyClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public SpiceproxyClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/lxc/{vmid}/spiceproxy".replace("{node}", node).replace("{vmid}", vmId);
    }

    /**
     * Returns a SPICE configuration to connect to the CT.
     */
    public void spiceproxy(String proxy) {
        Map<String, Object> options = new HashMap<>();
        if (proxy != null) {
            options.put("proxy", proxy);
        }
        executor.post(this.basePath, options);
    }
}