package io.github.pve.client.resource.nodes.firewall;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.firewall.rules.RulesClient;
import io.github.pve.client.resource.nodes.firewall.options.OptionsClient;
import io.github.pve.client.resource.nodes.firewall.log.LogClient;

/**
 * Client for /nodes/{node}/firewall
 * BY '@xiao-rao'
 */
public class FirewallClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public FirewallClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/firewall".replace("{" + "node" + "}", node);
    }

    /**
     * Directory index.
     */
    public List<Object> index() {
        PveResponse<List<Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `rules`
     */
    public RulesClient rules() {
        return new RulesClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `options`
     */
    public OptionsClient options() {
        return new OptionsClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `log`
     */
    public LogClient log() {
        return new LogClient(this.executor, this.node);
    }
}