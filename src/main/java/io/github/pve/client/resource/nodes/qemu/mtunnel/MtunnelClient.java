package io.github.pve.client.resource.nodes.qemu.mtunnel;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/qemu/{vmid}/mtunnel
 * BY '@xiao-rao'
 */
public class MtunnelClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public MtunnelClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/qemu/{vmid}/mtunnel".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Migration tunnel endpoint - only for internal use by VM migration.
     */
    public void mtunnel(String bridges, String storages) {
        Map<String, Object> options = new HashMap<>();
        if (bridges != null) {
            options.put("bridges", bridges);
        }
        if (storages != null) {
            options.put("storages", storages);
        }
        executor.post(this.basePath, options);
    }
}