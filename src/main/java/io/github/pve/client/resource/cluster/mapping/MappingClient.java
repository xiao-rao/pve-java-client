package io.github.pve.client.resource.cluster.mapping;

import java.util.List;
import java.util.Map;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.cluster.mapping.dir.DirClient;
import io.github.pve.client.resource.cluster.mapping.pci.PciClient;
import io.github.pve.client.resource.cluster.mapping.usb.UsbClient;

/**
 * Client for /cluster/mapping
 * BY '@xiao-rao'
 */
public class MappingClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public MappingClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/mapping";
    }

    /**
     * List resource types.
     */
    public List<Map<String, Object>> index() {
        PveResponse<List<Map<String, Object>>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `dir`
     */
    public DirClient dir() {
        return new DirClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `pci`
     */
    public PciClient pci() {
        return new PciClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `usb`
     */
    public UsbClient usb() {
        return new UsbClient(this.executor);
    }
}