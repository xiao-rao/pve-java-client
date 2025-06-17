package io.github.pve.client.resource.nodes.qemu.firewall;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.qemu.firewall.rules.RulesClient;
import io.github.pve.client.resource.nodes.qemu.firewall.aliases.AliasesClient;
import io.github.pve.client.resource.nodes.qemu.firewall.ipset.IpsetClient;
import io.github.pve.client.resource.nodes.qemu.firewall.options.OptionsClient;
import io.github.pve.client.resource.nodes.qemu.firewall.log.LogClient;
import io.github.pve.client.resource.nodes.qemu.firewall.refs.RefsClient;

/**
 * Client for /nodes/{node}/qemu/{vmid}/firewall
 * BY '@xiao-rao'
 */
public class FirewallClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public FirewallClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/qemu/{vmid}/firewall".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
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
        return new RulesClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `aliases`
     */
    public AliasesClient aliases() {
        return new AliasesClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `ipset`
     */
    public IpsetClient ipset() {
        return new IpsetClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `options`
     */
    public OptionsClient options() {
        return new OptionsClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `log`
     */
    public LogClient log() {
        return new LogClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `refs`
     */
    public RefsClient refs() {
        return new RefsClient(this.executor, this.node, this.vmid);
    }
}