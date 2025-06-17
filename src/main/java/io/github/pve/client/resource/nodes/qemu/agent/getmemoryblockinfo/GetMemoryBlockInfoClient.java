package io.github.pve.client.resource.nodes.qemu.agent.getmemoryblockinfo;

import java.util.Map;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/qemu/{vmid}/agent/get-memory-block-info
 * BY '@xiao-rao'
 */
public class GetMemoryBlockInfoClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public GetMemoryBlockInfoClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/qemu/{vmid}/agent/get-memory-block-info".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Execute get-memory-block-info.
     */
    public Map<String, Object> getMemoryBlockInfo() {
        PveResponse<Map<String, Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}