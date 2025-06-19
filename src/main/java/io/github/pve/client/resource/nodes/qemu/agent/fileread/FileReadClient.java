package io.github.pve.client.resource.nodes.qemu.agent.fileread;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.qemu.agent.fileread.*;

/**
 * Client for /nodes/{node}/qemu/{vmid}/agent/file-read
 * BY '@xiao-rao'
 */
public class FileReadClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public FileReadClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/qemu/{vmid}/agent/file-read".replace("{node}", node).replace("{vmid}", vmId);
    }

    /**
     * Reads the given file via guest agent. Is limited to 16777216 bytes.
     */
    public FileReadResponse fileRead(String file) {
        Map<String, Object> queryParams = new HashMap<>();
        if (file != null) {
            queryParams.put("file", file);
        }
        PveResponse<FileReadResponse> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}