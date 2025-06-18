package io.github.pve.client.resource.cluster.sdn.ipams;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.cluster.sdn.ipams.status.StatusClient;
// Import models if needed
import io.github.pve.client.model.cluster.sdn.ipams.*;

/**
 * Client for /cluster/sdn/ipams
 * BY '@xiao-rao'
 */
public class IpamsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public IpamsClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/sdn/ipams";
    }

    /**
     * SDN ipams index.
     */
    public List<SdnIpamsIndexResponse> index(String type) {
        Map<String, Object> queryParams = new HashMap<>();
        if (type != null) {
            queryParams.put("type", type);
        }
        PveResponse<List<SdnIpamsIndexResponse>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create a new sdn ipam object.
     */
    public void create(CreateRequest request) {
        executor.post(this.basePath, request);
    }

    /**
     * Delete sdn ipam object configuration.
     */
    public void delete(String ipam) {
        executor.delete(this.basePath + "/" + ipam);
    }

    /**
     * Read sdn ipam configuration.
     */
    public Map<String, Object> read(String ipam) {
        PveResponse<Map<String, Object>> response = executor.get(this.basePath + "/" + ipam, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Update sdn ipam object configuration.
     */
    public void update(UpdateRequest request) {
        executor.put(this.basePath + "/" + request.getIpam(), request);
    }

    /**
     * Client for the specific `ipam` resource.
     * @param ipam The path parameter `ipam`.
     */
    public StatusClient status(String ipam) {
        return new StatusClient(this.executor, ipam);
    }
}