package io.github.pve.client.resource.nodes.ceph.rules;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.ceph.rules.*;

/**
 * Client for /nodes/{node}/ceph/rules
 * BY '@xiao-rao'
 */
public class RulesClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public RulesClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/ceph/rules".replace("{" + "node" + "}", node);
    }

    /**
     * List ceph rules.
     */
    public List<RulesResponse> rules() {
        PveResponse<List<RulesResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}