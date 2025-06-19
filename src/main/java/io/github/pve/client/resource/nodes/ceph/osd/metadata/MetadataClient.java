package io.github.pve.client.resource.nodes.ceph.osd.metadata;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.ceph.osd.metadata.*;

/**
 * Client for /nodes/{node}/ceph/osd/{osdid}/metadata
 * BY '@xiao-rao'
 */
public class MetadataClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String osdId;

    public MetadataClient(ProxmoxApiExecutor executor, String node, String osdId) {
        this.executor = executor;
        this.node = node;
        this.osdId = osdId;
        this.basePath = "/nodes/{node}/ceph/osd/{osdid}/metadata".replace("{node}", node).replace("{osdid}", osdId);
    }

    /**
     * Get OSD details
     */
    public OsddetailsResponse osddetails() {
        PveResponse<OsddetailsResponse> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}