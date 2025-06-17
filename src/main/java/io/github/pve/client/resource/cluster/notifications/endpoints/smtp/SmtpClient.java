package io.github.pve.client.resource.cluster.notifications.endpoints.smtp;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.notifications.endpoints.smtp.*;

/**
 * Client for /cluster/notifications/endpoints/smtp
 * BY '@xiao-rao'
 */
public class SmtpClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public SmtpClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/notifications/endpoints/smtp";
    }

    /**
     * Returns a list of all smtp endpoints
     */
    public GetSmtpEndpointsResponse getSmtpEndpoints() {
        PveResponse<GetSmtpEndpointsResponse> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create a new smtp endpoint
     */
    public void createSmtpEndpoint(CreateSmtpEndpointRequest request) {
        executor.post(this.basePath, request);
    }

    /**
     * Remove smtp endpoint
     */
    public void deleteSmtpEndpoint(String name) {
        executor.delete(this.basePath + "/" + name);
    }

    /**
     * Return a specific smtp endpoint
     */
    public GetSmtpEndpointResponse getSmtpEndpoint(String name) {
        PveResponse<GetSmtpEndpointResponse> response = executor.get(this.basePath + "/" + name, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Update existing smtp endpoint
     */
    public void updateSmtpEndpoint(UpdateSmtpEndpointRequest request) {
        executor.put(this.basePath + "/" + request.getName(), request);
    }
}