package io.github.pve.client.resource.nodes.capabilities.qemu.machines;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.capabilities.qemu.machines.*;

/**
 * Client for /nodes/{node}/capabilities/qemu/machines
 * BY '@xiao-rao'
 */
public class MachinesClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public MachinesClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/capabilities/qemu/machines".replace("{" + "node" + "}", node);
    }

    /**
     * Get available QEMU/KVM machine types.
     */
    public List<TypesResponse> types() {
        PveResponse<List<TypesResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}