package io.github.pve.client.resource.nodes.subscription;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.subscription.*;

/**
 * Client for /nodes/{node}/subscription
 * BY '@xiao-rao'
 */
public class SubscriptionClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public SubscriptionClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/subscription".replace("{" + "node" + "}", node);
    }

    /**
     * Delete subscription key of this node.
     */
    public void delete() {
        executor.delete(this.basePath);
    }

    /**
     * Read subscription info.
     */
    public GetResponse get() {
        PveResponse<GetResponse> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Update subscription info.
     */
    public void update(Boolean force) {
        Map<String, Object> options = new HashMap<>();
        if (force != null) {
            options.put("force", force);
        }
        executor.post(this.basePath, options);
    }

    /**
     * Set subscription key.
     */
    public void set(String key) {
        Map<String, Object> options = new HashMap<>();
        if (key != null) {
            options.put("key", key);
        }
        executor.put(this.basePath, options);
    }
}