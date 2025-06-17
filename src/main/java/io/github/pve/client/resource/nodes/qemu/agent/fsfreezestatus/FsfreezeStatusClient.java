package io.github.pve.client.resource.nodes.qemu.agent.fsfreezestatus;

import java.util.Map;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/qemu/{vmid}/agent/fsfreeze-status
 * BY '@xiao-rao'
 */
public class FsfreezeStatusClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public FsfreezeStatusClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/qemu/{vmid}/agent/fsfreeze-status".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Execute fsfreeze-status.
     */
    public Map<String, Object> fsfreezeStatus() {
        PveResponse<Map<String, Object>> response = executor.post(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}