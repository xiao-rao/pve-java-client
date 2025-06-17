package io.github.pve.client.resource.nodes.lxc.firewall.ipset;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.lxc.firewall.ipset.*;

/**
 * Client for /nodes/{node}/lxc/{vmid}/firewall/ipset
 * BY '@xiao-rao'
 */
public class IpsetClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public IpsetClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/lxc/{vmid}/firewall/ipset".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * List IPSets
     */
    public List<Object> ipsetIndex() {
        PveResponse<List<Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
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
    public GetIpsetResponse getIpset(String name) {
        PveResponse<GetIpsetResponse> response = executor.get(this.basePath + "/" + name, null, new TypeReference<>() {});
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
    public void readIp(String cidr, String name) {
        executor.get(this.basePath + "/" + name + "/" + cidr);
    }

    /**
     * Update IP or Network settings
     */
    public void updateIp(UpdateIpRequest request) {
        executor.put(this.basePath + "/" + request.getName() + "/" + request.getCidr(), request);
    }
}