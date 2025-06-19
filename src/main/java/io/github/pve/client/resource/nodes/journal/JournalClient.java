package io.github.pve.client.resource.nodes.journal;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/journal
 * BY '@xiao-rao'
 */
public class JournalClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public JournalClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/journal".replace("{node}", node);
    }

    /**
     * Read Journal
     */
    public List<String> journal(String endcursor, Integer lastentries, Integer since, String startcursor, Integer until) {
        Map<String, Object> queryParams = new HashMap<>();
        if (endcursor != null) {
            queryParams.put("endcursor", endcursor);
        }
        if (lastentries != null) {
            queryParams.put("lastentries", lastentries);
        }
        if (since != null) {
            queryParams.put("since", since);
        }
        if (startcursor != null) {
            queryParams.put("startcursor", startcursor);
        }
        if (until != null) {
            queryParams.put("until", until);
        }
        PveResponse<List<String>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}