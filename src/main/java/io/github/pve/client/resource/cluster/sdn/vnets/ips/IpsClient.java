package io.github.pve.client.resource.cluster.sdn.vnets.ips;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.sdn.vnets.ips.*;

/**
 * Client for /cluster/sdn/vnets/{vnet}/ips
 * BY '@xiao-rao'
 */
public class IpsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String vnet;

    public IpsClient(ProxmoxApiExecutor executor, String vnet) {
        this.executor = executor;
        this.vnet = vnet;
        this.basePath = "/cluster/sdn/vnets/{vnet}/ips".replace("{vnet}", vnet);
    }

    /**
     * Delete IP Mappings in a VNet
     */
    public void ipdelete(String ip, String mac, String zone) {
        Map<String, Object> options = new HashMap<>();
        if (ip != null) {
            options.put("ip", ip);
        }
        if (mac != null) {
            options.put("mac", mac);
        }
        if (zone != null) {
            options.put("zone", zone);
        }
        executor.delete(this.basePath, options);
    }

    /**
     * Create IP Mapping in a VNet
     */
    public void ipcreate(IpcreateRequest request) {
        executor.post(this.basePath, request);
    }

    /**
     * Update IP Mapping in a VNet
     */
    public void ipupdate(IpupdateRequest request) {
        executor.put(this.basePath + "/" + request.getVmId(), request);
    }
}