package io.github.pve.client.resource.nodes.qemu.rrddata;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/qemu/{vmid}/rrddata
 * BY '@xiao-rao'
 */
public class RrddataClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public RrddataClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/qemu/{vmid}/rrddata".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Read VM RRD statistics
     */
    public List<Object> rrddata(String cf, String timeframe) {
        Map<String, Object> queryParams = new HashMap<>();
        if (cf != null) {
            queryParams.put("cf", cf);
        }
        if (timeframe != null) {
            queryParams.put("timeframe", timeframe);
        }
        PveResponse<List<Object>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}