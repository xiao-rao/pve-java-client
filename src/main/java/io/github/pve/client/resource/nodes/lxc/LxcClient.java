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
        this.basePath = "/nodes/{node}/lxc".replace("{node}", node);
    }

    /**
     * LXC container index (per node).
     */
    public List<VmlistResponse> vmlist() {
        PveResponse<List<VmlistResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create or restore a container.
     */
    public String createVm(CreateVmRequest request) {
        PveResponse<String> response = executor.post(this.basePath + "/" + request.getStorage() + "/" + request.getVmId(), request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Destroy the container (also delete all uses files).
     */
    public String destroyVm(String vmId, Boolean destroyUnreferencedDisks, Boolean force, Boolean purge) {
        String path = this.basePath + "/" + vmId;
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
    public ConfigClient config(String vmId) {
        return new ConfigClient(this.executor, this.node, vmId);
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
    public SnapshotClient snapshot(String vmId) {
        return new SnapshotClient(this.executor, this.node, vmId);
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
    public RemoteMigrateClient remoteMigrate(String vmId) {
        return new RemoteMigrateClient(this.executor, this.node, vmId);
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
    public FeatureClient feature(String vmId) {
        return new FeatureClient(this.executor, this.node, vmId);
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
    public CloneClient clone(String vmId) {
        return new CloneClient(this.executor, this.node, vmId);
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
    public MoveVolumeClient moveVolume(String vmId) {
        return new MoveVolumeClient(this.executor, this.node, vmId);
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
    public InterfacesClient interfaces(String vmId) {
        return new InterfacesClient(this.executor, this.node, vmId);
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