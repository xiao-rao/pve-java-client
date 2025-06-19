package io.github.pve.client.resource.nodes.lxc.firewall;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.lxc.firewall.rules.RulesClient;
import io.github.pve.client.resource.nodes.lxc.firewall.aliases.AliasesClient;
import io.github.pve.client.resource.nodes.lxc.firewall.ipset.IpsetClient;
import io.github.pve.client.resource.nodes.lxc.firewall.options.OptionsClient;
import io.github.pve.client.resource.nodes.lxc.firewall.log.LogClient;
import io.github.pve.client.resource.nodes.lxc.firewall.refs.RefsClient;

/**
 * Client for /nodes/{node}/lxc/{vmid}/firewall
 * BY '@xiao-rao'
 */
public class FirewallClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public FirewallClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/lxc/{vmid}/firewall".replace("{node}", node).replace("{vmid}", vmId);
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
        return new RulesClient(this.executor, this.node, this.vmId);
    }

    /**
     * Returns a client for the sub-resource: `aliases`
     */
    public AliasesClient aliases() {
        return new AliasesClient(this.executor, this.node, this.vmId);
    }

    /**
     * Returns a client for the sub-resource: `ipset`
     */
    public IpsetClient ipset() {
        return new IpsetClient(this.executor, this.node, this.vmId);
    }

    /**
     * Returns a client for the sub-resource: `options`
     */
    public OptionsClient options() {
        return new OptionsClient(this.executor, this.node, this.vmId);
    }

    /**
     * Returns a client for the sub-resource: `log`
     */
    public LogClient log() {
        return new LogClient(this.executor, this.node, this.vmId);
    }

    /**
     * Returns a client for the sub-resource: `refs`
     */
    public RefsClient refs() {
        return new RefsClient(this.executor, this.node, this.vmId);
    }
}