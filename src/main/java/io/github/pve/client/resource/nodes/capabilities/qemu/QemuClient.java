package io.github.pve.client.resource.nodes.capabilities.qemu;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.capabilities.qemu.cpu.CpuClient;
import io.github.pve.client.resource.nodes.capabilities.qemu.machines.MachinesClient;

/**
 * Client for /nodes/{node}/capabilities/qemu
 * BY '@xiao-rao'
 */
public class QemuClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public QemuClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/capabilities/qemu".replace("{" + "node" + "}", node);
    }

    /**
     * QEMU capabilities index.
     */
    public List<Object> qemuCapsIndex() {
        PveResponse<List<Object>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `cpu`
     */
    public CpuClient cpu() {
        return new CpuClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `machines`
     */
    public MachinesClient machines() {
        return new MachinesClient(this.executor, this.node);
    }
}