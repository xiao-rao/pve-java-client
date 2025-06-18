package io.github.pve.client.resource.cluster.firewall.macros;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.firewall.macros.*;

/**
 * Client for /cluster/firewall/macros
 * BY '@xiao-rao'
 */
public class MacrosClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public MacrosClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/firewall/macros";
    }

    /**
     * List available macros
     */
    public List<GetMacrosResponse> getMacros() {
        PveResponse<List<GetMacrosResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}