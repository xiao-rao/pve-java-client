package io.github.pve.client.resource.nodes.qemu.spiceproxy;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/qemu/{vmid}/spiceproxy
 * BY '@xiao-rao'
 */
public class SpiceproxyClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public SpiceproxyClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/qemu/{vmid}/spiceproxy".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Returns a SPICE configuration to connect to the VM.
     */
    public void spiceproxy(String proxy) {
        Map<String, Object> options = new HashMap<>();
        if (proxy != null) {
            options.put("proxy", proxy);
        }
        executor.post(this.basePath, options);
    }
}