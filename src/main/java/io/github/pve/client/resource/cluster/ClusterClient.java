package io.github.pve.client.resource.cluster;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.cluster.replication.ReplicationClient;
import io.github.pve.client.resource.cluster.metrics.MetricsClient;
import io.github.pve.client.resource.cluster.notifications.NotificationsClient;
import io.github.pve.client.resource.cluster.config.ConfigClient;
import io.github.pve.client.resource.cluster.firewall.FirewallClient;
import io.github.pve.client.resource.cluster.backup.BackupClient;
import io.github.pve.client.resource.cluster.backupinfo.BackupInfoClient;
import io.github.pve.client.resource.cluster.ha.HaClient;
import io.github.pve.client.resource.cluster.acme.AcmeClient;
import io.github.pve.client.resource.cluster.ceph.CephClient;
import io.github.pve.client.resource.cluster.jobs.JobsClient;
import io.github.pve.client.resource.cluster.mapping.MappingClient;
import io.github.pve.client.resource.cluster.sdn.SdnClient;
import io.github.pve.client.resource.cluster.log.LogClient;
import io.github.pve.client.resource.cluster.resources.ResourcesClient;
import io.github.pve.client.resource.cluster.tasks.TasksClient;
import io.github.pve.client.resource.cluster.options.OptionsClient;
import io.github.pve.client.resource.cluster.status.StatusClient;
import io.github.pve.client.resource.cluster.nextid.NextidClient;

/**
 * Client for /cluster
 * BY '@xiao-rao'
 */
public class ClusterClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public ClusterClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster";
    }

    /**
     * Cluster index.
     */
    public List<Object> index() {
        PveResponse<List<Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `replication`
     */
    public ReplicationClient replication() {
        return new ReplicationClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `metrics`
     */
    public MetricsClient metrics() {
        return new MetricsClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `notifications`
     */
    public NotificationsClient notifications() {
        return new NotificationsClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `config`
     */
    public ConfigClient config() {
        return new ConfigClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `firewall`
     */
    public FirewallClient firewall() {
        return new FirewallClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `backup`
     */
    public BackupClient backup() {
        return new BackupClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `backupInfo`
     */
    public BackupInfoClient backupInfo() {
        return new BackupInfoClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `ha`
     */
    public HaClient ha() {
        return new HaClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `acme`
     */
    public AcmeClient acme() {
        return new AcmeClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `ceph`
     */
    public CephClient ceph() {
        return new CephClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `jobs`
     */
    public JobsClient jobs() {
        return new JobsClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `mapping`
     */
    public MappingClient mapping() {
        return new MappingClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `sdn`
     */
    public SdnClient sdn() {
        return new SdnClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `log`
     */
    public LogClient log() {
        return new LogClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `resources`
     */
    public ResourcesClient resources() {
        return new ResourcesClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `tasks`
     */
    public TasksClient tasks() {
        return new TasksClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `options`
     */
    public OptionsClient options() {
        return new OptionsClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `status`
     */
    public StatusClient status() {
        return new StatusClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `nextid`
     */
    public NextidClient nextid() {
        return new NextidClient(this.executor);
    }
}