package io.github.pve.client.resource.cluster.firewall.ipset;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.firewall.ipset.*;

/**
 * Client for /cluster/firewall/ipset
 * BY '@xiao-rao'
 */
public class IpsetClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public IpsetClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/firewall/ipset";
    }

    /**
     * List IPSets
     */
    public List<IpsetIndexResponse> ipsetIndex() {
        PveResponse<List<IpsetIndexResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create new IPSet
     */
    public void createIpset(CreateIpsetRequest request) {
        executor.post(this.basePath, request);
    }

    /**
     * Delete IPSet
     */
    public void deleteIpset(String name, Boolean force) {
        String path = this.basePath + "/" + name;
        Map<String, Object> options = new HashMap<>();
        if (force != null) {
            options.put("force", force);
        }
        executor.delete(path, options);
    }

    /**
     * List IPSet content
     */
    public List<GetIpsetResponse> getIpset(String name) {
        PveResponse<List<GetIpsetResponse>> response = executor.get(this.basePath + "/" + name, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Add IP or Network to IPSet.
     */
    public void createIp(CreateIpRequest request) {
        executor.post(this.basePath + "/" + request.getName(), request);
    }

    /**
     * Remove IP or Network from IPSet.
     */
    public void removeIp(String cidr, String name, String digest) {
        String path = this.basePath + "/" + name;
        path = path + "/" + cidr;
        Map<String, Object> options = new HashMap<>();
        if (digest != null) {
            options.put("digest", digest);
        }
        executor.delete(path, options);
    }

    /**
     * Read IP or Network settings from IPSet.
     */
    public Map<String, Object> readIp(String cidr, String name) {
        PveResponse<Map<String, Object>> response = executor.get(this.basePath + "/" + name + "/" + cidr, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Update IP or Network settings
     */
    public void updateIp(UpdateIpRequest request) {
        executor.put(this.basePath + "/" + request.getName() + "/" + request.getCidr(), request);
    }
}