package io.github.pve.client.resource.cluster.backupinfo.notbackedup;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.backupinfo.notbackedup.*;

/**
 * Client for /cluster/backup-info/not-backed-up
 * BY '@xiao-rao'
 */
public class NotBackedUpClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public NotBackedUpClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/backup-info/not-backed-up";
    }

    /**
     * Shows all guests which are not covered by any backup job.
     */
    public List<GetGuestsNotInBackupResponse> getGuestsNotInBackup() {
        PveResponse<List<GetGuestsNotInBackupResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}