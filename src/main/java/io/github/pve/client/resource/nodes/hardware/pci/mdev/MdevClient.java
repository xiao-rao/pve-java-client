package io.github.pve.client.resource.nodes.hardware.pci.mdev;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.hardware.pci.mdev.*;

/**
 * Client for /nodes/{node}/hardware/pci/{pci-id-or-mapping}/mdev
 * BY '@xiao-rao'
 */
public class MdevClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String pciIdOrMapping;

    public MdevClient(ProxmoxApiExecutor executor, String node, String pciIdOrMapping) {
        this.executor = executor;
        this.node = node;
        this.pciIdOrMapping = pciIdOrMapping;
        this.basePath = "/nodes/{node}/hardware/pci/{pci-id-or-mapping}/mdev".replace("{node}", node).replace("{pci-id-or-mapping}", pciIdOrMapping);
    }

    /**
     * List mediated device types for given PCI device.
     */
    public List<MdevscanResponse> mdevscan() {
        PveResponse<List<MdevscanResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}