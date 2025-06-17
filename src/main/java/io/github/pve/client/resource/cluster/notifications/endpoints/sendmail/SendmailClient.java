package io.github.pve.client.resource.cluster.notifications.endpoints.sendmail;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.notifications.endpoints.sendmail.*;

/**
 * Client for /cluster/notifications/endpoints/sendmail
 * BY '@xiao-rao'
 */
public class SendmailClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public SendmailClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/notifications/endpoints/sendmail";
    }

    /**
     * Returns a list of all sendmail endpoints
     */
    public GetSendmailEndpointsResponse getSendmailEndpoints() {
        PveResponse<GetSendmailEndpointsResponse> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create a new sendmail endpoint
     */
    public void createSendmailEndpoint(CreateSendmailEndpointRequest request) {
        executor.post(this.basePath, request);
    }

    /**
     * Remove sendmail endpoint
     */
    public void deleteSendmailEndpoint(String name) {
        executor.delete(this.basePath + "/" + name);
    }

    /**
     * Return a specific sendmail endpoint
     */
    public GetSendmailEndpointResponse getSendmailEndpoint(String name) {
        PveResponse<GetSendmailEndpointResponse> response = executor.get(this.basePath + "/" + name, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Update existing sendmail endpoint
     */
    public void updateSendmailEndpoint(UpdateSendmailEndpointRequest request) {
        executor.put(this.basePath + "/" + request.getName(), request);
    }
}