package io.github.pve.client.resource.nodes.qemu.cloudinit.dump;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/qemu/{vmid}/cloudinit/dump
 * BY '@xiao-rao'
 */
public class DumpClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public DumpClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/qemu/{vmid}/cloudinit/dump".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Get automatically generated cloudinit config.
     */
    public String cloudinitGeneratedConfigDump(String type) {
        Map<String, Object> queryParams = new HashMap<>();
        if (type != null) {
            queryParams.put("type", type);
        }
        PveResponse<String> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}