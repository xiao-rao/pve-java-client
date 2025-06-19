package io.github.pve.client.resource.nodes.qemu.agent.filewrite;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.qemu.agent.filewrite.*;

/**
 * Client for /nodes/{node}/qemu/{vmid}/agent/file-write
 * BY '@xiao-rao'
 */
public class FileWriteClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public FileWriteClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/qemu/{vmid}/agent/file-write".replace("{node}", node).replace("{vmid}", vmId);
    }

    /**
     * Writes the given file via guest agent.
     */
    public void fileWrite(FileWriteRequest request) {
        executor.post(this.basePath, request);
    }
}