package io.github.pve.client.resource.cluster.jobs;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.cluster.jobs.realmsync.RealmSyncClient;
import io.github.pve.client.resource.cluster.jobs.scheduleanalyze.ScheduleAnalyzeClient;
// Import models if needed
import io.github.pve.client.model.cluster.jobs.*;

/**
 * Client for /cluster/jobs
 * BY '@xiao-rao'
 */
public class JobsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public JobsClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/jobs";
    }

    /**
     * Index for jobs related endpoints.
     */
    public List<ClusterJobsIndexResponse> index() {
        PveResponse<List<ClusterJobsIndexResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `realmSync`
     */
    public RealmSyncClient realmSync() {
        return new RealmSyncClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `scheduleAnalyze`
     */
    public ScheduleAnalyzeClient scheduleAnalyze() {
        return new ScheduleAnalyzeClient(this.executor);
    }
}