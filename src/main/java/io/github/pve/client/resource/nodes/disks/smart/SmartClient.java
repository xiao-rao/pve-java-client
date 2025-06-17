package io.github.pve.client.resource.nodes.disks.smart;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.disks.smart.*;

/**
 * Client for /nodes/{node}/disks/smart
 * BY '@xiao-rao'
 */
public class SmartClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public SmartClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/disks/smart".replace("{" + "node" + "}", node);
    }

    /**
     * Get SMART Health of a disk.
     */
    public SmartResponse smart(String disk, Boolean healthonly) {
        Map<String, Object> queryParams = new HashMap<>();
        if (disk != null) {
            queryParams.put("disk", disk);
        }
        if (healthonly != null) {
            queryParams.put("healthonly", healthonly);
        }
        PveResponse<SmartResponse> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}