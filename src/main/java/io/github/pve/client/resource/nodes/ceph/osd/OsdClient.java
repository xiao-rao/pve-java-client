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
        PveResponse<Map<String, Object>> response = executor.get(this.basePath, new TypeReference<>() {});
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
    public String destroyosd(String osdId, Boolean cleanup) {
        String path = this.basePath + "/" + osdId;
        Map<String, Object> options = new HashMap<>();
        if (cleanup != null) {
            options.put("cleanup", cleanup);
        }
        PveResponse<String> response = executor.delete(path, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * OSD index.
     */
    public List<Object> osdindex(String osdId) {
        PveResponse<List<Object>> response = executor.get(this.basePath + "/" + osdId, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Client for the specific `osdId` resource.
     * @param osdId The path parameter `osdId`.
     */
    public MetadataClient metadata(String osdId) {
        return new MetadataClient(this.executor, this.node, osdId);
    }

    /**
     * Client for the specific `osdId` resource.
     * @param osdId The path parameter `osdId`.
     */
    public LvInfoClient lvInfo(String osdId) {
        return new LvInfoClient(this.executor, this.node, osdId);
    }

    /**
     * Client for the specific `osdId` resource.
     * @param osdId The path parameter `osdId`.
     */
    public InClient in(String osdId) {
        return new InClient(this.executor, this.node, osdId);
    }

    /**
     * Client for the specific `osdId` resource.
     * @param osdId The path parameter `osdId`.
     */
    public OutClient out(String osdId) {
        return new OutClient(this.executor, this.node, osdId);
    }

    /**
     * Client for the specific `osdId` resource.
     * @param osdId The path parameter `osdId`.
     */
    public ScrubClient scrub(String osdId) {
        return new ScrubClient(this.executor, this.node, osdId);
    }
}