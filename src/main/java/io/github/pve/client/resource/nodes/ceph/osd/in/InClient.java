package io.github.pve.client.resource.nodes.ceph.osd.in;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/ceph/osd/{osdid}/in
 * BY '@xiao-rao'
 */
public class InClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String osdId;

    public InClient(ProxmoxApiExecutor executor, String node, String osdId) {
        this.executor = executor;
        this.node = node;
        this.osdId = osdId;
        this.basePath = "/nodes/{node}/ceph/osd/{osdid}/in".replace("{" + "node" + "}", node).replace("{" + "osdid" + "}", osdId);
    }

    /**
     * ceph osd in
     */
    public void in() {
        executor.post(this.basePath);
    }
}