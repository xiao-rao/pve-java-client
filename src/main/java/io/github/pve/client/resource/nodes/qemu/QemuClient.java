package io.github.pve.client.resource.nodes.qemu;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.qemu.firewall.FirewallClient;
import io.github.pve.client.resource.nodes.qemu.agent.AgentClient;
import io.github.pve.client.resource.nodes.qemu.rrd.RrdClient;
import io.github.pve.client.resource.nodes.qemu.rrddata.RrddataClient;
import io.github.pve.client.resource.nodes.qemu.config.ConfigClient;
import io.github.pve.client.resource.nodes.qemu.pending.PendingClient;
import io.github.pve.client.resource.nodes.qemu.cloudinit.CloudinitClient;
import io.github.pve.client.resource.nodes.qemu.unlink.UnlinkClient;
import io.github.pve.client.resource.nodes.qemu.vncproxy.VncproxyClient;
import io.github.pve.client.resource.nodes.qemu.termproxy.TermproxyClient;
import io.github.pve.client.resource.nodes.qemu.vncwebsocket.VncwebsocketClient;
import io.github.pve.client.resource.nodes.qemu.spiceproxy.SpiceproxyClient;
import io.github.pve.client.resource.nodes.qemu.status.StatusClient;
import io.github.pve.client.resource.nodes.qemu.sendkey.SendkeyClient;
import io.github.pve.client.resource.nodes.qemu.feature.FeatureClient;
import io.github.pve.client.resource.nodes.qemu.clone.CloneClient;
import io.github.pve.client.resource.nodes.qemu.move_disk.MoveDiskClient;
import io.github.pve.client.resource.nodes.qemu.migrate.MigrateClient;
import io.github.pve.client.resource.nodes.qemu.remote_migrate.RemoteMigrateClient;
import io.github.pve.client.resource.nodes.qemu.monitor.MonitorClient;
import io.github.pve.client.resource.nodes.qemu.resize.ResizeClient;
import io.github.pve.client.resource.nodes.qemu.snapshot.SnapshotClient;
import io.github.pve.client.resource.nodes.qemu.template.TemplateClient;
import io.github.pve.client.resource.nodes.qemu.mtunnel.MtunnelClient;
import io.github.pve.client.resource.nodes.qemu.mtunnelwebsocket.MtunnelwebsocketClient;
// Import models if needed
import io.github.pve.client.model.nodes.qemu.*;

/**
 * Client for /nodes/{node}/qemu
 * BY '@xiao-rao'
 */
public class QemuClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public QemuClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/qemu".replace("{node}", node);
    }

    /**
     * Virtual machine index (per node).
     */
    public List<VmlistResponse> vmlist(Boolean full) {
        Map<String, Object> queryParams = new HashMap<>();
        if (full != null) {
            queryParams.put("full", full);
        }
        PveResponse<List<VmlistResponse>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create or restore a virtual machine.
     */
    public String createVm(CreateVmRequest request) {
        PveResponse<String> response = executor.post(this.basePath + "/" + request.getStorage() + "/" + request.getVmgenId() + "/" + request.getVmId(), request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Destroy the VM and  all used/owned volumes. Removes any VM specific permissions and firewall rules
     */
    public String destroyVm(String vmId, Boolean destroyUnreferencedDisks, Boolean purge, Boolean skiplock) {
        String path = this.basePath + "/" + vmId;
        Map<String, Object> options = new HashMap<>();
        if (destroyUnreferencedDisks != null) {
            options.put("destroy-unreferenced-disks", destroyUnreferencedDisks);
        }
        if (purge != null) {
            options.put("purge", purge);
        }
        if (skiplock != null) {
            options.put("skiplock", skiplock);
        }
        PveResponse<String> response = executor.delete(path, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Directory index
     */
    public List<VmdiridxResponse> vmdiridx(String vmId) {
        PveResponse<List<VmdiridxResponse>> response = executor.get(this.basePath + "/" + vmId, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Client for the specific `vmId` resource.
     * @param vmId The path parameter `vmId`.
     */
    public FirewallClient firewall(String vmId) {
        return new FirewallClient(this.executor, this.node, vmId);
    }

    /**
     * Client for the specific `vmId` resource.
     * @param vmId The path parameter `vmId`.
     */
    public AgentClient agent(String vmId) {
        return new AgentClient(this.executor, this.node, vmId);
    }

    /**
     * Client for the specific `vmId` resource.
     * @param vmId The path parameter `vmId`.
     */
    public RrdClient rrd(String vmId) {
        return new RrdClient(this.executor, this.node, vmId);
    }

    /**
     * Client for the specific `vmId` resource.
     * @param vmId The path parameter `vmId`.
     */
    public RrddataClient rrddata(String vmId) {
        return new RrddataClient(this.executor, this.node, vmId);
    }

    /**
     * Client for the specific `vmId` resource.
     * @param vmId The path parameter `vmId`.
     */
    public ConfigClient config(String vmId) {
        return new ConfigClient(this.executor, this.node, vmId);
    }

    /**
     * Client for the specific `vmId` resource.
     * @param vmId The path parameter `vmId`.
     */
    public PendingClient pending(String vmId) {
        return new PendingClient(this.executor, this.node, vmId);
    }

    /**
     * Client for the specific `vmId` resource.
     * @param vmId The path parameter `vmId`.
     */
    public CloudinitClient cloudinit(String vmId) {
        return new CloudinitClient(this.executor, this.node, vmId);
    }

    /**
     * Client for the specific `vmId` resource.
     * @param vmId The path parameter `vmId`.
     */
    public UnlinkClient unlink(String vmId) {
        return new UnlinkClient(this.executor, this.node, vmId);
    }

    /**
     * Client for the specific `vmId` resource.
     * @param vmId The path parameter `vmId`.
     */
    public VncproxyClient vncproxy(String vmId) {
        return new VncproxyClient(this.executor, this.node, vmId);
    }

    /**
     * Client for the specific `vmId` resource.
     * @param vmId The path parameter `vmId`.
     */
    public TermproxyClient termproxy(String vmId) {
        return new TermproxyClient(this.executor, this.node, vmId);
    }

    /**
     * Client for the specific `vmId` resource.
     * @param vmId The path parameter `vmId`.
     */
    public VncwebsocketClient vncwebsocket(String vmId) {
        return new VncwebsocketClient(this.executor, this.node, vmId);
    }

    /**
     * Client for the specific `vmId` resource.
     * @param vmId The path parameter `vmId`.
     */
    public SpiceproxyClient spiceproxy(String vmId) {
        return new SpiceproxyClient(this.executor, this.node, vmId);
    }

    /**
     * Client for the specific `vmId` resource.
     * @param vmId The path parameter `vmId`.
     */
    public StatusClient status(String vmId) {
        return new StatusClient(this.executor, this.node, vmId);
    }

    /**
     * Client for the specific `vmId` resource.
     * @param vmId The path parameter `vmId`.
     */
    public SendkeyClient sendkey(String vmId) {
        return new SendkeyClient(this.executor, this.node, vmId);
    }

    /**
     * Client for the specific `vmId` resource.
     * @param vmId The path parameter `vmId`.
     */
    public FeatureClient feature(String vmId) {
        return new FeatureClient(this.executor, this.node, vmId);
    }

    /**
     * Client for the specific `vmId` resource.
     * @param vmId The path parameter `vmId`.
     */
    public CloneClient clone(String vmId) {
        return new CloneClient(this.executor, this.node, vmId);
    }

    /**
     * Client for the specific `vmId` resource.
     * @param vmId The path parameter `vmId`.
     */
    public MoveDiskClient moveDisk(String vmId) {
        return new MoveDiskClient(this.executor, this.node, vmId);
    }

    /**
     * Client for the specific `vmId` resource.
     * @param vmId The path parameter `vmId`.
     */
    public MigrateClient migrate(String vmId) {
        return new MigrateClient(this.executor, this.node, vmId);
    }

    /**
     * Client for the specific `vmId` resource.
     * @param vmId The path parameter `vmId`.
     */
    public RemoteMigrateClient remoteMigrate(String vmId) {
        return new RemoteMigrateClient(this.executor, this.node, vmId);
    }

    /**
     * Client for the specific `vmId` resource.
     * @param vmId The path parameter `vmId`.
     */
    public MonitorClient monitor(String vmId) {
        return new MonitorClient(this.executor, this.node, vmId);
    }

    /**
     * Client for the specific `vmId` resource.
     * @param vmId The path parameter `vmId`.
     */
    public ResizeClient resize(String vmId) {
        return new ResizeClient(this.executor, this.node, vmId);
    }

    /**
     * Client for the specific `vmId` resource.
     * @param vmId The path parameter `vmId`.
     */
    public SnapshotClient snapshot(String vmId) {
        return new SnapshotClient(this.executor, this.node, vmId);
    }

    /**
     * Client for the specific `vmId` resource.
     * @param vmId The path parameter `vmId`.
     */
    public TemplateClient template(String vmId) {
        return new TemplateClient(this.executor, this.node, vmId);
    }

    /**
     * Client for the specific `vmId` resource.
     * @param vmId The path parameter `vmId`.
     */
    public MtunnelClient mtunnel(String vmId) {
        return new MtunnelClient(this.executor, this.node, vmId);
    }

    /**
     * Client for the specific `vmId` resource.
     * @param vmId The path parameter `vmId`.
     */
    public MtunnelwebsocketClient mtunnelwebsocket(String vmId) {
        return new MtunnelwebsocketClient(this.executor, this.node, vmId);
    }
}