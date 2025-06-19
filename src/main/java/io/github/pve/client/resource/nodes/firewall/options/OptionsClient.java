package io.github.pve.client.resource.nodes.firewall.options;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.firewall.options.*;

/**
 * Client for /nodes/{node}/firewall/options
 * BY '@xiao-rao'
 */
public class OptionsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public OptionsClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/firewall/options".replace("{node}", node);
    }

    /**
     * Get host firewall options.
     */
    public GetOptionsResponse getOptions() {
        PveResponse<GetOptionsResponse> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Set Firewall options.
     */
    public void setOptions(SetOptionsRequest request) {
        executor.put(this.basePath + "/" + request.getNfConntrackAllowInvalId(), request);
    }
}