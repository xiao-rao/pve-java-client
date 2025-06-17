package io.github.pve.client.resource.nodes.lxc;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.lxc.config.ConfigClient;
import io.github.pve.client.resource.nodes.lxc.status.StatusClient;
import io.github.pve.client.resource.nodes.lxc.snapshot.SnapshotClient;
import io.github.pve.client.resource.nodes.lxc.firewall.FirewallClient;
import io.github.pve.client.resource.nodes.lxc.rrd.RrdClient;
import io.github.pve.client.resource.nodes.lxc.rrddata.RrddataClient;
import io.github.pve.client.resource.nodes.lxc.vncproxy.VncproxyClient;
import io.github.pve.client.resource.nodes.lxc.termproxy.TermproxyClient;
import io.github.pve.client.resource.nodes.lxc.vncwebsocket.VncwebsocketClient;
import io.github.pve.client.resource.nodes.lxc.spiceproxy.SpiceproxyClient;
import io.github.pve.client.resource.nodes.lxc.remote_migrate.RemoteMigrateClient;
import io.github.pve.client.resource.nodes.lxc.migrate.MigrateClient;
import io.github.pve.client.resource.nodes.lxc.feature.FeatureClient;
import io.github.pve.client.resource.nodes.lxc.template.TemplateClient;
import io.github.pve.client.resource.nodes.lxc.clone.CloneClient;
import io.github.pve.client.resource.nodes.lxc.resize.ResizeClient;
import io.github.pve.client.resource.nodes.lxc.move_volume.MoveVolumeClient;
import io.github.pve.client.resource.nodes.lxc.pending.PendingClient;
import io.github.pve.client.resource.nodes.lxc.interfaces.InterfacesClient;
import io.github.pve.client.resource.nodes.lxc.mtunnel.MtunnelClient;
import io.github.pve.client.resource.nodes.lxc.mtunnelwebsocket.MtunnelwebsocketClient;
// Import models if needed
import io.github.pve.client.model.nodes.lxc.*;

/**
 * Client for /nodes/{node}/lxc
 * BY '@xiao-rao'
 */
public class LxcClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public LxcClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/lxc".replace("{" + "node" + "}", node);
    }

    /**
     * LXC container index (per node).
     */
    public VmlistResponse vmlist() {
        PveResponse<VmlistResponse> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create or restore a container.
     */
    public String createVm(CreateVmRequest request) {
        PveResponse<String> response = executor.post(this.basePath + "/" + request.getStorage() + "/" + request.getVmid(), request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Destroy the container (also delete all uses files).
     */
    public void destroyVm(String vmid, Boolean destroyUnreferencedDisks, Boolean force, Boolean purge) {
        String path = this.basePath + "/" + vmid;
        Map<String, Object> options = new HashMap<>();
        if (destroyUnreferencedDisks != null) {
            options.put("destroy-unreferenced-disks", destroyUnreferencedDisks);
        }
        if (force != null) {
            options.put("force", force);
        }
        if (purge != null) {
            options.put("purge", purge);
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
    public ConfigClient config(String vmid) {
        return new ConfigClient(this.executor, this.node, vmid);
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
    public SnapshotClient snapshot(String vmid) {
        return new SnapshotClient(this.executor, this.node, vmid);
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
    public RemoteMigrateClient remoteMigrate(String vmid) {
        return new RemoteMigrateClient(this.executor, this.node, vmid);
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
    public FeatureClient feature(String vmid) {
        return new FeatureClient(this.executor, this.node, vmid);
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
    public CloneClient clone(String vmid) {
        return new CloneClient(this.executor, this.node, vmid);
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
    public MoveVolumeClient moveVolume(String vmid) {
        return new MoveVolumeClient(this.executor, this.node, vmid);
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
    public InterfacesClient interfaces(String vmid) {
        return new InterfacesClient(this.executor, this.node, vmid);
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