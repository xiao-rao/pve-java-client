package io.github.pve.client.resource.nodes.lxc.template;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/lxc/{vmid}/template
 * BY '@xiao-rao'
 */
public class TemplateClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public TemplateClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/lxc/{vmid}/template".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmId);
    }

    /**
     * Create a Template.
     */
    public void template() {
        executor.post(this.basePath);
    }
}