package io.github.pve.client.resource.nodes.scan.lvm;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.scan.lvm.*;

/**
 * Client for /nodes/{node}/scan/lvm
 * BY '@xiao-rao'
 */
public class LvmClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public LvmClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/scan/lvm".replace("{" + "node" + "}", node);
    }

    /**
     * List local LVM volume groups.
     */
    public List<LvmscanResponse> lvmscan() {
        PveResponse<List<LvmscanResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}