package io.github.pve.client.resource.cluster.backup;

import java.util.List;
import java.util.Map;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.cluster.backup.included_volumes.IncludedVolumesClient;
// Import models if needed
import io.github.pve.client.model.cluster.backup.*;

/**
 * Client for /cluster/backup
 * BY '@xiao-rao'
 */
public class BackupClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public BackupClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/backup";
    }

    /**
     * List vzdump backup schedule.
     */
    public List<Object> index() {
        PveResponse<List<Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create new vzdump backup job.
     */
    public void createJob(CreateJobRequest request) {
        executor.post(this.basePath, request);
    }

    /**
     * Delete vzdump backup job definition.
     */
    public void deleteJob(String id) {
        executor.delete(this.basePath + "/" + id);
    }

    /**
     * Read vzdump backup job definition.
     */
    public void readJob(String id) {
        executor.get(this.basePath + "/" + id);
    }

    /**
     * Update vzdump backup job definition.
     */
    public void updateJob(UpdateJobRequest request) {
        executor.put(this.basePath + "/" + request.getId(), request);
    }

    /**
     * Client for the specific `id` resource.
     * @param id The path parameter `id`.
     */
    public IncludedVolumesClient includedVolumes(String id) {
        return new IncludedVolumesClient(this.executor, id);
    }
}