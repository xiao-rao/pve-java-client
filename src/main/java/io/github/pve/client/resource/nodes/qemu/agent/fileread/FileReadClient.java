package io.github.pve.client.resource.nodes.qemu.agent.fileread;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/qemu/{vmid}/agent/file-read
 * BY '@xiao-rao'
 */
public class FileReadClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public FileReadClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/qemu/{vmid}/agent/file-read".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Reads the given file via guest agent. Is limited to 16777216 bytes.
     */
    public Object fileRead(String file) {
        Map<String, Object> queryParams = new HashMap<>();
        if (file != null) {
            queryParams.put("file", file);
        }
        PveResponse<Object> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}