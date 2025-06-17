package io.github.pve.client.resource.nodes.capabilities;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.capabilities.qemu.QemuClient;

/**
 * Client for /nodes/{node}/capabilities
 * BY '@xiao-rao'
 */
public class CapabilitiesClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public CapabilitiesClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/capabilities".replace("{" + "node" + "}", node);
    }

    /**
     * Node capabilities index.
     */
    public List<Object> index() {
        PveResponse<List<Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `qemu`
     */
    public QemuClient qemu() {
        return new QemuClient(this.executor, this.node);
    }
}