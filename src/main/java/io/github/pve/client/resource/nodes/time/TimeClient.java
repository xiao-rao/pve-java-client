package io.github.pve.client.resource.nodes.time;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/time
 * BY '@xiao-rao'
 */
public class TimeClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public TimeClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/time".replace("{" + "node" + "}", node);
    }

    /**
     * Read server time and time zone settings.
     */
    public Object time() {
        PveResponse<Object> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Set time zone.
     */
    public void setTimezone(String timezone) {
        Map<String, Object> options = new HashMap<>();
        if (timezone != null) {
            options.put("timezone", timezone);
        }
        executor.put(this.basePath, options);
    }
}