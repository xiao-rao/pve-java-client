package io.github.pve.client.resource.nodes.hardware.usb;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.hardware.usb.*;

/**
 * Client for /nodes/{node}/hardware/usb
 * BY '@xiao-rao'
 */
public class UsbClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public UsbClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/hardware/usb".replace("{" + "node" + "}", node);
    }

    /**
     * List local USB devices.
     */
    public UsbscanResponse usbscan() {
        PveResponse<UsbscanResponse> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}