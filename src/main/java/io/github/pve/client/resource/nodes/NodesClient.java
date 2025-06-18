package io.github.pve.client.resource.nodes;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.qemu.QemuClient;
import io.github.pve.client.resource.nodes.lxc.LxcClient;
import io.github.pve.client.resource.nodes.ceph.CephClient;
import io.github.pve.client.resource.nodes.vzdump.VzdumpClient;
import io.github.pve.client.resource.nodes.services.ServicesClient;
import io.github.pve.client.resource.nodes.subscription.SubscriptionClient;
import io.github.pve.client.resource.nodes.network.NetworkClient;
import io.github.pve.client.resource.nodes.tasks.TasksClient;
import io.github.pve.client.resource.nodes.scan.ScanClient;
import io.github.pve.client.resource.nodes.hardware.HardwareClient;
import io.github.pve.client.resource.nodes.capabilities.CapabilitiesClient;
import io.github.pve.client.resource.nodes.storage.StorageClient;
import io.github.pve.client.resource.nodes.disks.DisksClient;
import io.github.pve.client.resource.nodes.apt.AptClient;
import io.github.pve.client.resource.nodes.firewall.FirewallClient;
import io.github.pve.client.resource.nodes.replication.ReplicationClient;
import io.github.pve.client.resource.nodes.certificates.CertificatesClient;
import io.github.pve.client.resource.nodes.config.ConfigClient;
import io.github.pve.client.resource.nodes.sdn.SdnClient;
import io.github.pve.client.resource.nodes.version.VersionClient;
import io.github.pve.client.resource.nodes.status.StatusClient;
import io.github.pve.client.resource.nodes.netstat.NetstatClient;
import io.github.pve.client.resource.nodes.execute.ExecuteClient;
import io.github.pve.client.resource.nodes.wakeonlan.WakeonlanClient;
import io.github.pve.client.resource.nodes.rrd.RrdClient;
import io.github.pve.client.resource.nodes.rrddata.RrddataClient;
import io.github.pve.client.resource.nodes.syslog.SyslogClient;
import io.github.pve.client.resource.nodes.journal.JournalClient;
import io.github.pve.client.resource.nodes.vncshell.VncshellClient;
import io.github.pve.client.resource.nodes.termproxy.TermproxyClient;
import io.github.pve.client.resource.nodes.vncwebsocket.VncwebsocketClient;
import io.github.pve.client.resource.nodes.spiceshell.SpiceshellClient;
import io.github.pve.client.resource.nodes.dns.DnsClient;
import io.github.pve.client.resource.nodes.time.TimeClient;
import io.github.pve.client.resource.nodes.aplinfo.AplinfoClient;
import io.github.pve.client.resource.nodes.queryurlmetadata.QueryUrlMetadataClient;
import io.github.pve.client.resource.nodes.report.ReportClient;
import io.github.pve.client.resource.nodes.startall.StartallClient;
import io.github.pve.client.resource.nodes.stopall.StopallClient;
import io.github.pve.client.resource.nodes.suspendall.SuspendallClient;
import io.github.pve.client.resource.nodes.migrateall.MigrateallClient;
import io.github.pve.client.resource.nodes.hosts.HostsClient;
// Import models if needed
import io.github.pve.client.model.nodes.*;

/**
 * Client for /nodes
 * BY '@xiao-rao'
 */
public class NodesClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public NodesClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/nodes";
    }

    /**
     * Cluster node index.
     */
    public List<NodesIndexResponse> index() {
        PveResponse<List<NodesIndexResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Node index.
     */
    public List<Object> indexById(String node) {
        PveResponse<List<Object>> response = executor.get(this.basePath + "/" + node, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public QemuClient qemu(String node) {
        return new QemuClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public LxcClient lxc(String node) {
        return new LxcClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public CephClient ceph(String node) {
        return new CephClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public VzdumpClient vzdump(String node) {
        return new VzdumpClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public ServicesClient services(String node) {
        return new ServicesClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public SubscriptionClient subscription(String node) {
        return new SubscriptionClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public NetworkClient network(String node) {
        return new NetworkClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public TasksClient tasks(String node) {
        return new TasksClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public ScanClient scan(String node) {
        return new ScanClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public HardwareClient hardware(String node) {
        return new HardwareClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public CapabilitiesClient capabilities(String node) {
        return new CapabilitiesClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public StorageClient storage(String node) {
        return new StorageClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public DisksClient disks(String node) {
        return new DisksClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public AptClient apt(String node) {
        return new AptClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public FirewallClient firewall(String node) {
        return new FirewallClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public ReplicationClient replication(String node) {
        return new ReplicationClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public CertificatesClient certificates(String node) {
        return new CertificatesClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public ConfigClient config(String node) {
        return new ConfigClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public SdnClient sdn(String node) {
        return new SdnClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public VersionClient version(String node) {
        return new VersionClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public StatusClient status(String node) {
        return new StatusClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public NetstatClient netstat(String node) {
        return new NetstatClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public ExecuteClient execute(String node) {
        return new ExecuteClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public WakeonlanClient wakeonlan(String node) {
        return new WakeonlanClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public RrdClient rrd(String node) {
        return new RrdClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public RrddataClient rrddata(String node) {
        return new RrddataClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public SyslogClient syslog(String node) {
        return new SyslogClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public JournalClient journal(String node) {
        return new JournalClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public VncshellClient vncshell(String node) {
        return new VncshellClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public TermproxyClient termproxy(String node) {
        return new TermproxyClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public VncwebsocketClient vncwebsocket(String node) {
        return new VncwebsocketClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public SpiceshellClient spiceshell(String node) {
        return new SpiceshellClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public DnsClient dns(String node) {
        return new DnsClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public TimeClient time(String node) {
        return new TimeClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public AplinfoClient aplinfo(String node) {
        return new AplinfoClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public QueryUrlMetadataClient queryUrlMetadata(String node) {
        return new QueryUrlMetadataClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public ReportClient report(String node) {
        return new ReportClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public StartallClient startall(String node) {
        return new StartallClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public StopallClient stopall(String node) {
        return new StopallClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public SuspendallClient suspendall(String node) {
        return new SuspendallClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public MigrateallClient migrateall(String node) {
        return new MigrateallClient(this.executor, node);
    }

    /**
     * Client for the specific `node` resource.
     * @param node The path parameter `node`.
     */
    public HostsClient hosts(String node) {
        return new HostsClient(this.executor, node);
    }
}