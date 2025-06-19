package io.github.pve.client.resource.cluster.sdn.vnets.firewall;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.cluster.sdn.vnets.firewall.rules.RulesClient;
import io.github.pve.client.resource.cluster.sdn.vnets.firewall.options.OptionsClient;

/**
 * Client for /cluster/sdn/vnets/{vnet}/firewall
 * BY '@xiao-rao'
 */
public class FirewallClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String vnet;

    public FirewallClient(ProxmoxApiExecutor executor, String vnet) {
        this.executor = executor;
        this.vnet = vnet;
        this.basePath = "/cluster/sdn/vnets/{vnet}/firewall".replace("{vnet}", vnet);
    }

    /**
     * Directory index.
     */
    public List<Object> index() {
        PveResponse<List<Object>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `rules`
     */
    public RulesClient rules() {
        return new RulesClient(this.executor, this.vnet);
    }

    /**
     * Returns a client for the sub-resource: `options`
     */
    public OptionsClient options() {
        return new OptionsClient(this.executor, this.vnet);
    }
}