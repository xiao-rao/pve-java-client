package io.github.pve.client.resource.cluster.notifications.endpoints.gotify;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.notifications.endpoints.gotify.*;

/**
 * Client for /cluster/notifications/endpoints/gotify
 * BY '@xiao-rao'
 */
public class GotifyClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public GotifyClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/notifications/endpoints/gotify";
    }

    /**
     * Returns a list of all gotify endpoints
     */
    public GetGotifyEndpointsResponse getGotifyEndpoints() {
        PveResponse<GetGotifyEndpointsResponse> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create a new gotify endpoint
     */
    public void createGotifyEndpoint(CreateGotifyEndpointRequest request) {
        executor.post(this.basePath, request);
    }

    /**
     * Remove gotify endpoint
     */
    public void deleteGotifyEndpoint(String name) {
        executor.delete(this.basePath + "/" + name);
    }

    /**
     * Return a specific gotify endpoint
     */
    public GetGotifyEndpointResponse getGotifyEndpoint(String name) {
        PveResponse<GetGotifyEndpointResponse> response = executor.get(this.basePath + "/" + name, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Update existing gotify endpoint
     */
    public void updateGotifyEndpoint(UpdateGotifyEndpointRequest request) {
        executor.put(this.basePath + "/" + request.getName(), request);
    }
}