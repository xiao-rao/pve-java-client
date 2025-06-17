package io.github.pve.client.resource.cluster.jobs.realmsync;

import java.util.List;
import java.util.Map;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.jobs.realmsync.*;

/**
 * Client for /cluster/jobs/realm-sync
 * BY '@xiao-rao'
 */
public class RealmSyncClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public RealmSyncClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/jobs/realm-sync";
    }

    /**
     * List configured realm-sync-jobs.
     */
    public SyncjobIndexResponse syncjobIndex() {
        PveResponse<SyncjobIndexResponse> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Delete realm-sync job definition.
     */
    public void deleteJob(String id) {
        executor.delete(this.basePath + "/" + id);
    }

    /**
     * Read realm-sync job definition.
     */
    public void readJob(String id) {
        executor.get(this.basePath + "/" + id);
    }

    /**
     * Create new realm-sync job.
     */
    public void createJob(CreateJobRequest request) {
        executor.post(this.basePath + "/" + request.getId(), request);
    }

    /**
     * Update realm-sync job definition.
     */
    public void updateJob(UpdateJobRequest request) {
        executor.put(this.basePath + "/" + request.getId(), request);
    }
}