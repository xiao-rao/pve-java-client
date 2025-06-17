package io.github.pve.client.resource.nodes.disks.wipedisk;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/disks/wipedisk
 * BY '@xiao-rao'
 */
public class WipediskClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public WipediskClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/disks/wipedisk".replace("{" + "node" + "}", node);
    }

    /**
     * Wipe a disk or partition.
     */
    public String wipeDisk(String disk) {
        Map<String, Object> options = new HashMap<>();
        if (disk != null) {
            options.put("disk", disk);
        }
        PveResponse<String> response = executor.put(this.basePath, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}