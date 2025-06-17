package io.github.pve.client.resource.nodes.ceph.osd.lvinfo;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.ceph.osd.lvinfo.*;

/**
 * Client for /nodes/{node}/ceph/osd/{osdid}/lv-info
 * BY '@xiao-rao'
 */
public class LvInfoClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String osdid;

    public LvInfoClient(ProxmoxApiExecutor executor, String node, String osdid) {
        this.executor = executor;
        this.node = node;
        this.osdid = osdid;
        this.basePath = "/nodes/{node}/ceph/osd/{osdid}/lv-info".replace("{" + "node" + "}", node).replace("{" + "osdid" + "}", osdid);
    }

    /**
     * Get OSD volume details
     */
    public OsdvolumeResponse osdvolume(String type) {
        Map<String, Object> queryParams = new HashMap<>();
        if (type != null) {
            queryParams.put("type", type);
        }
        PveResponse<OsdvolumeResponse> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}