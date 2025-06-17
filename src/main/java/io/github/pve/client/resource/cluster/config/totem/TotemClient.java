package io.github.pve.client.resource.cluster.config.totem;

import java.util.Map;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /cluster/config/totem
 * BY '@xiao-rao'
 */
public class TotemClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public TotemClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/config/totem";
    }

    /**
     * Get corosync totem protocol settings.
     */
    public Map<String, Object> totem() {
        PveResponse<Map<String, Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}