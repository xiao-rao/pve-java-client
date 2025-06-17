package io.github.pve.client.resource.nodes.apt.update;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/apt/update
 * BY '@xiao-rao'
 */
public class UpdateClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public UpdateClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/apt/update".replace("{" + "node" + "}", node);
    }

    /**
     * List available updates.
     */
    public List<Object> listUpdates() {
        PveResponse<List<Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * This is used to resynchronize the package index files from their sources (apt-get update).
     */
    public String updateDatabase(Boolean notify, Boolean quiet) {
        Map<String, Object> options = new HashMap<>();
        if (notify != null) {
            options.put("notify", notify);
        }
        if (quiet != null) {
            options.put("quiet", quiet);
        }
        PveResponse<String> response = executor.post(this.basePath, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}