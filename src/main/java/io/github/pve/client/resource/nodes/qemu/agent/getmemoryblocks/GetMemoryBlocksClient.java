package io.github.pve.client.resource.nodes.qemu.agent.getmemoryblocks;

import java.util.Map;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/qemu/{vmid}/agent/get-memory-blocks
 * BY '@xiao-rao'
 */
public class GetMemoryBlocksClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public GetMemoryBlocksClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/qemu/{vmid}/agent/get-memory-blocks".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Execute get-memory-blocks.
     */
    public Map<String, Object> getMemoryBlocks() {
        PveResponse<Map<String, Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}