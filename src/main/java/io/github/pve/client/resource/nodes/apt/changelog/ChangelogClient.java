package io.github.pve.client.resource.nodes.apt.changelog;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/apt/changelog
 * BY '@xiao-rao'
 */
public class ChangelogClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public ChangelogClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/apt/changelog".replace("{" + "node" + "}", node);
    }

    /**
     * Get package changelogs.
     */
    public String changelog(String name, String version) {
        Map<String, Object> queryParams = new HashMap<>();
        if (name != null) {
            queryParams.put("name", name);
        }
        if (version != null) {
            queryParams.put("version", version);
        }
        PveResponse<String> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}