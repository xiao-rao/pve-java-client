package io.github.pve.client.resource.nodes.ceph.osd.metadata;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/ceph/osd/{osdid}/metadata
 * BY '@xiao-rao'
 */
public class MetadataClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String osdid;

    public MetadataClient(ProxmoxApiExecutor executor, String node, String osdid) {
        this.executor = executor;
        this.node = node;
        this.osdid = osdid;
        this.basePath = "/nodes/{node}/ceph/osd/{osdid}/metadata".replace("{" + "node" + "}", node).replace("{" + "osdid" + "}", osdid);
    }

    /**
     * Get OSD details
     */
    public Object osddetails() {
        PveResponse<Object> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}