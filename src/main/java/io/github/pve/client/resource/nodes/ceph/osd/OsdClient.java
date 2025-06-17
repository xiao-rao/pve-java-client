package io.github.pve.client.resource.nodes.ceph.osd;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.ceph.osd.metadata.MetadataClient;
import io.github.pve.client.resource.nodes.ceph.osd.lvinfo.LvInfoClient;
import io.github.pve.client.resource.nodes.ceph.osd.in.InClient;
import io.github.pve.client.resource.nodes.ceph.osd.out.OutClient;
import io.github.pve.client.resource.nodes.ceph.osd.scrub.ScrubClient;
// Import models if needed
import io.github.pve.client.model.nodes.ceph.osd.*;

/**
 * Client for /nodes/{node}/ceph/osd
 * BY '@xiao-rao'
 */
public class OsdClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public OsdClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/ceph/osd".replace("{" + "node" + "}", node);
    }

    /**
     * Get Ceph osd list/tree.
     */
    public Map<String, Object> index() {
        PveResponse<Map<String, Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create OSD
     */
    public String createosd(CreateosdRequest request) {
        PveResponse<String> response = executor.post(this.basePath, request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Destroy OSD
     */
    public void destroyosd(String osdid, Boolean cleanup) {
        String path = this.basePath + "/" + osdid;
        Map<String, Object> options = new HashMap<>();
        if (cleanup != null) {
            options.put("cleanup", cleanup);
        }
        executor.delete(path, options);
    }

    /**
     * OSD index.
     */
    public void osdindex(String osdid) {
        executor.get(this.basePath + "/" + osdid);
    }

    /**
     * Client for the specific `osdid` resource.
     * @param osdid The path parameter `osdid`.
     */
    public MetadataClient metadata(String osdid) {
        return new MetadataClient(this.executor, this.node, osdid);
    }

    /**
     * Client for the specific `osdid` resource.
     * @param osdid The path parameter `osdid`.
     */
    public LvInfoClient lvInfo(String osdid) {
        return new LvInfoClient(this.executor, this.node, osdid);
    }

    /**
     * Client for the specific `osdid` resource.
     * @param osdid The path parameter `osdid`.
     */
    public InClient in(String osdid) {
        return new InClient(this.executor, this.node, osdid);
    }

    /**
     * Client for the specific `osdid` resource.
     * @param osdid The path parameter `osdid`.
     */
    public OutClient out(String osdid) {
        return new OutClient(this.executor, this.node, osdid);
    }

    /**
     * Client for the specific `osdid` resource.
     * @param osdid The path parameter `osdid`.
     */
    public ScrubClient scrub(String osdid) {
        return new ScrubClient(this.executor, this.node, osdid);
    }
}