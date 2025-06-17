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
    protected final String vmid;

    public TermproxyClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/lxc/{vmid}/termproxy".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Creates a TCP proxy connection.
     */
    public void termproxy() {
        executor.post(this.basePath);
    }
}