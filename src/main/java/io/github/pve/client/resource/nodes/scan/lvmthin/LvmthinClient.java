package io.github.pve.client.resource.nodes.scan.lvmthin;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.scan.lvmthin.*;

/**
 * Client for /nodes/{node}/scan/lvmthin
 * BY '@xiao-rao'
 */
public class LvmthinClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public LvmthinClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/scan/lvmthin".replace("{node}", node);
    }

    /**
     * List local LVM Thin Pools.
     */
    public List<LvmthinscanResponse> lvmthinscan(String vg) {
        Map<String, Object> queryParams = new HashMap<>();
        if (vg != null) {
            queryParams.put("vg", vg);
        }
        PveResponse<List<LvmthinscanResponse>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}