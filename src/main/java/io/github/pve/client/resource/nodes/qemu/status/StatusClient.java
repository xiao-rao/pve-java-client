package io.github.pve.client.resource.nodes.qemu.status;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.qemu.status.current.CurrentClient;
import io.github.pve.client.resource.nodes.qemu.status.start.StartClient;
import io.github.pve.client.resource.nodes.qemu.status.stop.StopClient;
import io.github.pve.client.resource.nodes.qemu.status.reset.ResetClient;
import io.github.pve.client.resource.nodes.qemu.status.shutdown.ShutdownClient;
import io.github.pve.client.resource.nodes.qemu.status.reboot.RebootClient;
import io.github.pve.client.resource.nodes.qemu.status.suspend.SuspendClient;
import io.github.pve.client.resource.nodes.qemu.status.resume.ResumeClient;
// Import models if needed
import io.github.pve.client.model.nodes.qemu.status.*;

/**
 * Client for /nodes/{node}/qemu/{vmid}/status
 * BY '@xiao-rao'
 */
public class StatusClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public StatusClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/qemu/{vmid}/status".replace("{node}", node).replace("{vmid}", vmId);
    }

    /**
     * Directory index
     */
    public List<VmcmdidxResponse> vmcmdidx() {
        PveResponse<List<VmcmdidxResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `current`
     */
    public CurrentClient current() {
        return new CurrentClient(this.executor, this.node, this.vmId);
    }

    /**
     * Returns a client for the sub-resource: `start`
     */
    public StartClient start() {
        return new StartClient(this.executor, this.node, this.vmId);
    }

    /**
     * Returns a client for the sub-resource: `stop`
     */
    public StopClient stop() {
        return new StopClient(this.executor, this.node, this.vmId);
    }

    /**
     * Returns a client for the sub-resource: `reset`
     */
    public ResetClient reset() {
        return new ResetClient(this.executor, this.node, this.vmId);
    }

    /**
     * Returns a client for the sub-resource: `shutdown`
     */
    public ShutdownClient shutdown() {
        return new ShutdownClient(this.executor, this.node, this.vmId);
    }

    /**
     * Returns a client for the sub-resource: `reboot`
     */
    public RebootClient reboot() {
        return new RebootClient(this.executor, this.node, this.vmId);
    }

    /**
     * Returns a client for the sub-resource: `suspend`
     */
    public SuspendClient suspend() {
        return new SuspendClient(this.executor, this.node, this.vmId);
    }

    /**
     * Returns a client for the sub-resource: `resume`
     */
    public ResumeClient resume() {
        return new ResumeClient(this.executor, this.node, this.vmId);
    }
}