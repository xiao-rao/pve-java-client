package io.github.pve.client.resource.cluster.backupinfo;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.cluster.backupinfo.notbackedup.NotBackedUpClient;
// Import models if needed
import io.github.pve.client.model.cluster.backupinfo.*;

/**
 * Client for /cluster/backup-info
 * BY '@xiao-rao'
 */
public class BackupInfoClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public BackupInfoClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/backup-info";
    }

    /**
     * Index for backup info related endpoints
     */
    public List<ClusterBackupinfoIndexResponse> index() {
        PveResponse<List<ClusterBackupinfoIndexResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `notBackedUp`
     */
    public NotBackedUpClient notBackedUp() {
        return new NotBackedUpClient(this.executor);
    }
}