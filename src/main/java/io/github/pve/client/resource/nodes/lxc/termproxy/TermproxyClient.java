package io.github.pve.client.resource.nodes.lxc.termproxy;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/lxc/{vmid}/termproxy
 * BY '@xiao-rao'
 */
public class TermproxyClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public TermproxyClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/lxc/{vmid}/termproxy".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmId);
    }

    /**
     * Creates a TCP proxy connection.
     */
    public void termproxy() {
        executor.post(this.basePath);
    }
}