package io.github.pve.client.resource.nodes.hardware;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.hardware.pci.PciClient;
import io.github.pve.client.resource.nodes.hardware.usb.UsbClient;

/**
 * Client for /nodes/{node}/hardware
 * BY '@xiao-rao'
 */
public class HardwareClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public HardwareClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/hardware".replace("{" + "node" + "}", node);
    }

    /**
     * Index of hardware types
     */
    public List<Object> index() {
        PveResponse<List<Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `pci`
     */
    public PciClient pci() {
        return new PciClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `usb`
     */
    public UsbClient usb() {
        return new UsbClient(this.executor, this.node);
    }
}