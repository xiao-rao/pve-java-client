package io.github.pve.client.resource.cluster.sdn.vnets.firewall.options;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.sdn.vnets.firewall.options.*;

/**
 * Client for /cluster/sdn/vnets/{vnet}/firewall/options
 * BY '@xiao-rao'
 */
public class OptionsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String vnet;

    public OptionsClient(ProxmoxApiExecutor executor, String vnet) {
        this.executor = executor;
        this.vnet = vnet;
        this.basePath = "/cluster/sdn/vnets/{vnet}/firewall/options".replace("{" + "vnet" + "}", vnet);
    }

    /**
     * Get vnet firewall options.
     */
    public Object getOptions() {
        PveResponse<Object> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Set Firewall options.
     */
    public void setOptions(SetOptionsRequest request) {
        executor.put(this.basePath, request);
    }
}