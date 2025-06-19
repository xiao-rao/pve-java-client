package io.github.pve.client.resource.nodes.dns;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.dns.*;

/**
 * Client for /nodes/{node}/dns
 * BY '@xiao-rao'
 */
public class DnsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public DnsClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/dns".replace("{node}", node);
    }

    /**
     * Read DNS settings.
     */
    public DnsResponse dns() {
        PveResponse<DnsResponse> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Write DNS settings.
     */
    public void updateDns(UpdateDnsRequest request) {
        executor.put(this.basePath, request);
    }
}