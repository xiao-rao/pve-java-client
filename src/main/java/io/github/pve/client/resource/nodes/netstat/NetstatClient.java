package io.github.pve.client.resource.nodes.netstat;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/netstat
 * BY '@xiao-rao'
 */
public class NetstatClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public NetstatClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/netstat".replace("{" + "node" + "}", node);
    }

    /**
     * Read tap/vm network device interface counters
     */
    public List<Object> netstat() {
        PveResponse<List<Object>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}