package io.github.pve.client.resource.nodes.qemu.agent.execstatus;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.qemu.agent.execstatus.*;

/**
 * Client for /nodes/{node}/qemu/{vmid}/agent/exec-status
 * BY '@xiao-rao'
 */
public class ExecStatusClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public ExecStatusClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/qemu/{vmid}/agent/exec-status".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Gets the status of the given pid started by the guest-agent
     */
    public ExecStatusResponse execStatus(String pid) {
        PveResponse<ExecStatusResponse> response = executor.get(this.basePath + "/" + pid, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}