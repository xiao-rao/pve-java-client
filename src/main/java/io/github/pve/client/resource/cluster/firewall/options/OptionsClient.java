package io.github.pve.client.resource.cluster.firewall.options;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.firewall.options.*;

/**
 * Client for /cluster/firewall/options
 * BY '@xiao-rao'
 */
public class OptionsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public OptionsClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/firewall/options";
    }

    /**
     * Get Firewall options.
     */
    public GetOptionsResponse getOptions() {
        PveResponse<GetOptionsResponse> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Set Firewall options.
     */
    public void setOptions(SetOptionsRequest request) {
        executor.put(this.basePath, request);
    }
}