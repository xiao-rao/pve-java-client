package io.github.pve.client.resource.cluster.firewall;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.cluster.firewall.groups.GroupsClient;
import io.github.pve.client.resource.cluster.firewall.rules.RulesClient;
import io.github.pve.client.resource.cluster.firewall.ipset.IpsetClient;
import io.github.pve.client.resource.cluster.firewall.aliases.AliasesClient;
import io.github.pve.client.resource.cluster.firewall.options.OptionsClient;
import io.github.pve.client.resource.cluster.firewall.macros.MacrosClient;
import io.github.pve.client.resource.cluster.firewall.refs.RefsClient;

/**
 * Client for /cluster/firewall
 * BY '@xiao-rao'
 */
public class FirewallClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public FirewallClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/firewall";
    }

    /**
     * Directory index.
     */
    public List<Object> index() {
        PveResponse<List<Object>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `groups`
     */
    public GroupsClient groups() {
        return new GroupsClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `rules`
     */
    public RulesClient rules() {
        return new RulesClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `ipset`
     */
    public IpsetClient ipset() {
        return new IpsetClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `aliases`
     */
    public AliasesClient aliases() {
        return new AliasesClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `options`
     */
    public OptionsClient options() {
        return new OptionsClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `macros`
     */
    public MacrosClient macros() {
        return new MacrosClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `refs`
     */
    public RefsClient refs() {
        return new RefsClient(this.executor);
    }
}