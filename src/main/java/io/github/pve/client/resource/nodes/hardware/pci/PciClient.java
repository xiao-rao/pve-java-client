package io.github.pve.client.resource.nodes.hardware.pci;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.hardware.pci.mdev.MdevClient;
// Import models if needed
import io.github.pve.client.model.nodes.hardware.pci.*;

/**
 * Client for /nodes/{node}/hardware/pci
 * BY '@xiao-rao'
 */
public class PciClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public PciClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/hardware/pci".replace("{node}", node);
    }

    /**
     * List local PCI devices.
     */
    public List<PciScanResponse> pciScan(String pciClassBlacklist, Boolean verbose) {
        Map<String, Object> queryParams = new HashMap<>();
        if (pciClassBlacklist != null) {
            queryParams.put("pci-class-blacklist", pciClassBlacklist);
        }
        if (verbose != null) {
            queryParams.put("verbose", verbose);
        }
        PveResponse<List<PciScanResponse>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Index of available pci methods
     */
    public List<PciIndexResponse> pciIndex(String pciIdOrMapping) {
        PveResponse<List<PciIndexResponse>> response = executor.get(this.basePath + "/" + pciIdOrMapping, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Client for the specific `pciIdOrMapping` resource.
     * @param pciIdOrMapping The path parameter `pciIdOrMapping`.
     */
    public MdevClient mdev(String pciIdOrMapping) {
        return new MdevClient(this.executor, this.node, pciIdOrMapping);
    }
}