package io.github.pve.client.resource.cluster.sdn;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.cluster.sdn.vnets.VnetsClient;
import io.github.pve.client.resource.cluster.sdn.zones.ZonesClient;
import io.github.pve.client.resource.cluster.sdn.controllers.ControllersClient;
import io.github.pve.client.resource.cluster.sdn.ipams.IpamsClient;
import io.github.pve.client.resource.cluster.sdn.dns.DnsClient;

/**
 * Client for /cluster/sdn
 * BY '@xiao-rao'
 */
public class SdnClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public SdnClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/sdn";
    }

    /**
     * Directory index.
     */
    public List<Object> index() {
        PveResponse<List<Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Apply sdn controller changes && reload.
     */
    public String reload() {
        PveResponse<String> response = executor.put(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `vnets`
     */
    public VnetsClient vnets() {
        return new VnetsClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `zones`
     */
    public ZonesClient zones() {
        return new ZonesClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `controllers`
     */
    public ControllersClient controllers() {
        return new ControllersClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `ipams`
     */
    public IpamsClient ipams() {
        return new IpamsClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `dns`
     */
    public DnsClient dns() {
        return new DnsClient(this.executor);
    }
}