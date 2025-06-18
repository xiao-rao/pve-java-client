package io.github.pve.client.resource.nodes.scan.zfs;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.scan.zfs.*;

/**
 * Client for /nodes/{node}/scan/zfs
 * BY '@xiao-rao'
 */
public class ZfsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public ZfsClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/scan/zfs".replace("{" + "node" + "}", node);
    }

    /**
     * Scan zfs pool list on local node.
     */
    public List<ZfsscanResponse> zfsscan() {
        PveResponse<List<ZfsscanResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}