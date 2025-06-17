package io.github.pve.client.resource.cluster.mapping.usb;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.mapping.usb.*;

/**
 * Client for /cluster/mapping/usb
 * BY '@xiao-rao'
 */
public class UsbClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public UsbClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/mapping/usb";
    }

    /**
     * List USB Hardware Mappings
     */
    public IndexResponse index(String checkNode) {
        Map<String, Object> queryParams = new HashMap<>();
        if (checkNode != null) {
            queryParams.put("check-node", checkNode);
        }
        PveResponse<IndexResponse> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create a new hardware mapping.
     */
    public void create(CreateRequest request) {
        executor.post(this.basePath, request);
    }

    /**
     * Remove Hardware Mapping.
     */
    public void delete(String id) {
        executor.delete(this.basePath + "/" + id);
    }

    /**
     * Get USB Mapping.
     */
    public void get(String id) {
        executor.get(this.basePath + "/" + id);
    }

    /**
     * Update a hardware mapping.
     */
    public void update(UpdateRequest request) {
        executor.put(this.basePath + "/" + request.getId(), request);
    }
}