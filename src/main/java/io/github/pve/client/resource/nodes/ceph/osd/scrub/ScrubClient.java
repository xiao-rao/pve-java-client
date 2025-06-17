package io.github.pve.client.resource.nodes.ceph.osd.scrub;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/ceph/osd/{osdid}/scrub
 * BY '@xiao-rao'
 */
public class ScrubClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String osdid;

    public ScrubClient(ProxmoxApiExecutor executor, String node, String osdid) {
        this.executor = executor;
        this.node = node;
        this.osdid = osdid;
        this.basePath = "/nodes/{node}/ceph/osd/{osdid}/scrub".replace("{" + "node" + "}", node).replace("{" + "osdid" + "}", osdid);
    }

    /**
     * Instruct the OSD to scrub.
     */
    public void scrub(Boolean deep) {
        Map<String, Object> options = new HashMap<>();
        if (deep != null) {
            options.put("deep", deep);
        }
        executor.post(this.basePath, options);
    }
}