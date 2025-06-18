package io.github.pve.client.resource.cluster.notifications.endpoints.webhook;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.notifications.endpoints.webhook.*;

/**
 * Client for /cluster/notifications/endpoints/webhook
 * BY '@xiao-rao'
 */
public class WebhookClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public WebhookClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/notifications/endpoints/webhook";
    }

    /**
     * Returns a list of all webhook endpoints
     */
    public List<GetWebhookEndpointsResponse> getWebhookEndpoints() {
        PveResponse<List<GetWebhookEndpointsResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create a new webhook endpoint
     */
    public void createWebhookEndpoint(CreateWebhookEndpointRequest request) {
        executor.post(this.basePath, request);
    }

    /**
     * Remove webhook endpoint
     */
    public void deleteWebhookEndpoint(String name) {
        executor.delete(this.basePath + "/" + name);
    }

    /**
     * Return a specific webhook endpoint
     */
    public GetWebhookEndpointResponse getWebhookEndpoint(String name) {
        PveResponse<GetWebhookEndpointResponse> response = executor.get(this.basePath + "/" + name, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Update existing webhook endpoint
     */
    public void updateWebhookEndpoint(UpdateWebhookEndpointRequest request) {
        executor.put(this.basePath + "/" + request.getName(), request);
    }
}