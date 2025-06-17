package io.github.pve.client.resource.cluster.notifications.matchers;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.notifications.matchers.*;

/**
 * Client for /cluster/notifications/matchers
 * BY '@xiao-rao'
 */
public class MatchersClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public MatchersClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/notifications/matchers";
    }

    /**
     * Returns a list of all matchers
     */
    public GetMatchersResponse getMatchers() {
        PveResponse<GetMatchersResponse> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create a new matcher
     */
    public void createMatcher(CreateMatcherRequest request) {
        executor.post(this.basePath, request);
    }

    /**
     * Remove matcher
     */
    public void deleteMatcher(String name) {
        executor.delete(this.basePath + "/" + name);
    }

    /**
     * Return a specific matcher
     */
    public GetMatcherResponse getMatcher(String name) {
        PveResponse<GetMatcherResponse> response = executor.get(this.basePath + "/" + name, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Update existing matcher
     */
    public void updateMatcher(UpdateMatcherRequest request) {
        executor.put(this.basePath + "/" + request.getName(), request);
    }
}