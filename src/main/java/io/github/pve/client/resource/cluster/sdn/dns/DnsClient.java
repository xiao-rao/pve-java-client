package io.github.pve.client.resource.cluster.sdn.dns;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.sdn.dns.*;

/**
 * Client for /cluster/sdn/dns
 * BY '@xiao-rao'
 */
public class DnsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public DnsClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/sdn/dns";
    }

    /**
     * SDN dns index.
     */
    public List<SdnDnsIndexResponse> index(String type) {
        Map<String, Object> queryParams = new HashMap<>();
        if (type != null) {
            queryParams.put("type", type);
        }
        PveResponse<List<SdnDnsIndexResponse>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create a new sdn dns object.
     */
    public void create(CreateRequest request) {
        executor.post(this.basePath, request);
    }

    /**
     * Delete sdn dns object configuration.
     */
    public void delete(String dns) {
        executor.delete(this.basePath + "/" + dns);
    }

    /**
     * Read sdn dns configuration.
     */
    public Map<String, Object> read(String dns) {
        PveResponse<Map<String, Object>> response = executor.get(this.basePath + "/" + dns, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Update sdn dns object configuration.
     */
    public void update(UpdateRequest request) {
        executor.put(this.basePath + "/" + request.getDns(), request);
    }
}