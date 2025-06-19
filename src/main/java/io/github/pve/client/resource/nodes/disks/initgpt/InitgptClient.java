package io.github.pve.client.resource.nodes.disks.initgpt;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/disks/initgpt
 * BY '@xiao-rao'
 */
public class InitgptClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public InitgptClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/disks/initgpt".replace("{node}", node);
    }

    /**
     * Initialize Disk with GPT
     */
    public String initgpt(String uuId, String disk) {
        String path = this.basePath + "/" + uuId;
        Map<String, Object> options = new HashMap<>();
        if (disk != null) {
            options.put("disk", disk);
        }
        PveResponse<String> response = executor.post(path, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}