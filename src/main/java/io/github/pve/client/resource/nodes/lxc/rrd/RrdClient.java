package io.github.pve.client.resource.nodes.lxc.rrd;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/lxc/{vmid}/rrd
 * BY '@xiao-rao'
 */
public class RrdClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public RrdClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/lxc/{vmid}/rrd".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Read VM RRD statistics (returns PNG)
     */
    public Object rrd(String cf, String ds, String timeframe) {
        Map<String, Object> queryParams = new HashMap<>();
        if (cf != null) {
            queryParams.put("cf", cf);
        }
        if (ds != null) {
            queryParams.put("ds", ds);
        }
        if (timeframe != null) {
            queryParams.put("timeframe", timeframe);
        }
        PveResponse<Object> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}