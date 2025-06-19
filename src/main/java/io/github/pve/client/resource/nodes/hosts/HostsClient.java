package io.github.pve.client.resource.nodes.hosts;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.hosts.*;

/**
 * Client for /nodes/{node}/hosts
 * BY '@xiao-rao'
 */
public class HostsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public HostsClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/hosts".replace("{node}", node);
    }

    /**
     * Get the content of /etc/hosts.
     */
    public GetEtcHostsResponse getEtcHosts() {
        PveResponse<GetEtcHostsResponse> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Write /etc/hosts.
     */
    public void writeEtcHosts(String data, String digest) {
        Map<String, Object> options = new HashMap<>();
        if (data != null) {
            options.put("data", data);
        }
        if (digest != null) {
            options.put("digest", digest);
        }
        executor.post(this.basePath, options);
    }
}