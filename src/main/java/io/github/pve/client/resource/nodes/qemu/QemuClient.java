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
        this.basePath = "/nodes/{node}/qemu".replace("{" + "node" + "}", node);
    }

    /**
     * Virtual machine index (per node).
     */
    public VmlistResponse vmlist(Boolean full) {
        Map<String, Object> queryParams = new HashMap<>();
        if (full != null) {
            queryParams.put("full", full);
        }
        PveResponse<VmlistResponse> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create or restore a virtual machine.
     */
    public String createVm(CreateVmRequest request) {
        PveResponse<String> response = executor.post(this.basePath + "/" + request.getStorage() + "/" + request.getVmgenid() + "/" + request.getVmid(), request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Destroy the VM and  all used/owned volumes. Removes any VM specific permissions and firewall rules
     */
    public void destroyVm(String vmid, Boolean destroyUnreferencedDisks, Boolean purge, Boolean skiplock) {
        String path = this.basePath + "/" + vmid;
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
        executor.delete(path, options);
    }

    /**
     * Directory index
     */
    public void vmdiridx(String vmid) {
        executor.get(this.basePath + "/" + vmid);
    }

    /**
     * Client for the specific `vmid` resource.
     * @param vmid The path parameter `vmid`.
     */
    public FirewallClient firewall(String vmid) {
        return new FirewallClient(this.executor, this.node, vmid);
    }

    /**
     * Client for the specific `vmid` resource.
     * @param vmid The path parameter `vmid`.
     */
    public AgentClient agent(String vmid) {
        return new AgentClient(this.executor, this.node, vmid);
    }

    /**
     * Client for the specific `vmid` resource.
     * @param vmid The path parameter `vmid`.
     */
    public RrdClient rrd(String vmid) {
        return new RrdClient(this.executor, this.node, vmid);
    }

    /**
     * Client for the specific `vmid` resource.
     * @param vmid The path parameter `vmid`.
     */
    public RrddataClient rrddata(String vmid) {
        return new RrddataClient(this.executor, this.node, vmid);
    }

    /**
     * Client for the specific `vmid` resource.
     * @param vmid The path parameter `vmid`.
     */
    public ConfigClient config(String vmid) {
        return new ConfigClient(this.executor, this.node, vmid);
    }

    /**
     * Client for the specific `vmid` resource.
     * @param vmid The path parameter `vmid`.
     */
    public PendingClient pending(String vmid) {
        return new PendingClient(this.executor, this.node, vmid);
    }

    /**
     * Client for the specific `vmid` resource.
     * @param vmid The path parameter `vmid`.
     */
    public CloudinitClient cloudinit(String vmid) {
        return new CloudinitClient(this.executor, this.node, vmid);
    }

    /**
     * Client for the specific `vmid` resource.
     * @param vmid The path parameter `vmid`.
     */
    public UnlinkClient unlink(String vmid) {
        return new UnlinkClient(this.executor, this.node, vmid);
    }

    /**
     * Client for the specific `vmid` resource.
     * @param vmid The path parameter `vmid`.
     */
    public VncproxyClient vncproxy(String vmid) {
        return new VncproxyClient(this.executor, this.node, vmid);
    }

    /**
     * Client for the specific `vmid` resource.
     * @param vmid The path parameter `vmid`.
     */
    public TermproxyClient termproxy(String vmid) {
        return new TermproxyClient(this.executor, this.node, vmid);
    }

    /**
     * Client for the specific `vmid` resource.
     * @param vmid The path parameter `vmid`.
     */
    public VncwebsocketClient vncwebsocket(String vmid) {
        return new VncwebsocketClient(this.executor, this.node, vmid);
    }

    /**
     * Client for the specific `vmid` resource.
     * @param vmid The path parameter `vmid`.
     */
    public SpiceproxyClient spiceproxy(String vmid) {
        return new SpiceproxyClient(this.executor, this.node, vmid);
    }

    /**
     * Client for the specific `vmid` resource.
     * @param vmid The path parameter `vmid`.
     */
    public StatusClient status(String vmid) {
        return new StatusClient(this.executor, this.node, vmid);
    }

    /**
     * Client for the specific `vmid` resource.
     * @param vmid The path parameter `vmid`.
     */
    public SendkeyClient sendkey(String vmid) {
        return new SendkeyClient(this.executor, this.node, vmid);
    }

    /**
     * Client for the specific `vmid` resource.
     * @param vmid The path parameter `vmid`.
     */
    public FeatureClient feature(String vmid) {
        return new FeatureClient(this.executor, this.node, vmid);
    }

    /**
     * Client for the specific `vmid` resource.
     * @param vmid The path parameter `vmid`.
     */
    public CloneClient clone(String vmid) {
        return new CloneClient(this.executor, this.node, vmid);
    }

    /**
     * Client for the specific `vmid` resource.
     * @param vmid The path parameter `vmid`.
     */
    public MoveDiskClient moveDisk(String vmid) {
        return new MoveDiskClient(this.executor, this.node, vmid);
    }

    /**
     * Client for the specific `vmid` resource.
     * @param vmid The path parameter `vmid`.
     */
    public MigrateClient migrate(String vmid) {
        return new MigrateClient(this.executor, this.node, vmid);
    }

    /**
     * Client for the specific `vmid` resource.
     * @param vmid The path parameter `vmid`.
     */
    public RemoteMigrateClient remoteMigrate(String vmid) {
        return new RemoteMigrateClient(this.executor, this.node, vmid);
    }

    /**
     * Client for the specific `vmid` resource.
     * @param vmid The path parameter `vmid`.
     */
    public MonitorClient monitor(String vmid) {
        return new MonitorClient(this.executor, this.node, vmid);
    }

    /**
     * Client for the specific `vmid` resource.
     * @param vmid The path parameter `vmid`.
     */
    public ResizeClient resize(String vmid) {
        return new ResizeClient(this.executor, this.node, vmid);
    }

    /**
     * Client for the specific `vmid` resource.
     * @param vmid The path parameter `vmid`.
     */
    public SnapshotClient snapshot(String vmid) {
        return new SnapshotClient(this.executor, this.node, vmid);
    }

    /**
     * Client for the specific `vmid` resource.
     * @param vmid The path parameter `vmid`.
     */
    public TemplateClient template(String vmid) {
        return new TemplateClient(this.executor, this.node, vmid);
    }

    /**
     * Client for the specific `vmid` resource.
     * @param vmid The path parameter `vmid`.
     */
    public MtunnelClient mtunnel(String vmid) {
        return new MtunnelClient(this.executor, this.node, vmid);
    }

    /**
     * Client for the specific `vmid` resource.
     * @param vmid The path parameter `vmid`.
     */
    public MtunnelwebsocketClient mtunnelwebsocket(String vmid) {
        return new MtunnelwebsocketClient(this.executor, this.node, vmid);
    }
}