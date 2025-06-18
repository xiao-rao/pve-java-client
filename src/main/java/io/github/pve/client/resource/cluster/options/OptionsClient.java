package io.github.pve.client.resource.cluster.options;

import java.util.Map;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.options.*;

/**
 * Client for /cluster/options
 * BY '@xiao-rao'
 */
public class OptionsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public OptionsClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/options";
    }

    /**
     * Get datacenter options. Without 'Sys.Audit' on '/' not all options are returned.
     */
    public Map<String, Object> getOptions() {
        PveResponse<Map<String, Object>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Set datacenter options.
     */
    public void setOptions(SetOptionsRequest request) {
        executor.put(this.basePath, request);
    }
}