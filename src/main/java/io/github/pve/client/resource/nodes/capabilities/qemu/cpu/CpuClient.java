package io.github.pve.client.resource.nodes.capabilities.qemu.cpu;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.capabilities.qemu.cpu.*;

/**
 * Client for /nodes/{node}/capabilities/qemu/cpu
 * BY '@xiao-rao'
 */
public class CpuClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public CpuClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/capabilities/qemu/cpu".replace("{" + "node" + "}", node);
    }

    /**
     * List all custom and default CPU models.
     */
    public List<QemuCpuIndexResponse> index() {
        PveResponse<List<QemuCpuIndexResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}