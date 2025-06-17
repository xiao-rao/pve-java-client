package io.github.pve.client.resource.nodes.storage.prunebackups;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.storage.prunebackups.*;

/**
 * Client for /nodes/{node}/storage/{storage}/prunebackups
 * BY '@xiao-rao'
 */
public class PrunebackupsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String storage;

    public PrunebackupsClient(ProxmoxApiExecutor executor, String node, String storage) {
        this.executor = executor;
        this.node = node;
        this.storage = storage;
        this.basePath = "/nodes/{node}/storage/{storage}/prunebackups".replace("{" + "node" + "}", node).replace("{" + "storage" + "}", storage);
    }

    /**
     * Prune backups. Only those using the standard naming scheme are considered.
     */
    public String delete(String vmid, String pruneBackups, String type) {
        String path = this.basePath + "/" + vmid;
        Map<String, Object> options = new HashMap<>();
        if (pruneBackups != null) {
            options.put("prune-backups", pruneBackups);
        }
        if (type != null) {
            options.put("type", type);
        }
        PveResponse<String> response = executor.delete(path, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Get prune information for backups. NOTE: this is only a preview and might not be what a subsequent prune call does if backups are removed/added in the meantime.
     */
    public DryrunResponse dryrun(String vmid, String pruneBackups, String type) {
        String path = this.basePath + "/" + vmid;
        Map<String, Object> queryParams = new HashMap<>();
        if (pruneBackups != null) {
            queryParams.put("prune-backups", pruneBackups);
        }
        if (type != null) {
            queryParams.put("type", type);
        }
        PveResponse<DryrunResponse> response = executor.get(path, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}