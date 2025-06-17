package io.github.pve.client.resource.cluster.backup.included_volumes;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /cluster/backup/{id}/included_volumes
 * BY '@xiao-rao'
 */
public class IncludedVolumesClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String id;

    public IncludedVolumesClient(ProxmoxApiExecutor executor, String id) {
        this.executor = executor;
        this.id = id;
        this.basePath = "/cluster/backup/{id}/included_volumes".replace("{" + "id" + "}", id);
    }

    /**
     * Returns included guests and the backup status of their disks. Optimized to be used in ExtJS tree views.
     */
    public Object getVolumeBackupIncluded() {
        PveResponse<Object> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}