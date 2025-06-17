package io.github.pve.client.resource.nodes.ceph.osd.out;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/ceph/osd/{osdid}/out
 * BY '@xiao-rao'
 */
public class OutClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String osdid;

    public OutClient(ProxmoxApiExecutor executor, String node, String osdid) {
        this.executor = executor;
        this.node = node;
        this.osdid = osdid;
        this.basePath = "/nodes/{node}/ceph/osd/{osdid}/out".replace("{" + "node" + "}", node).replace("{" + "osdid" + "}", osdid);
    }

    /**
     * ceph osd out
     */
    public void out() {
        executor.post(this.basePath);
    }
}