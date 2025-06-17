package io.github.pve.client.resource.cluster.notifications.endpoints;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.cluster.notifications.endpoints.sendmail.SendmailClient;
import io.github.pve.client.resource.cluster.notifications.endpoints.gotify.GotifyClient;
import io.github.pve.client.resource.cluster.notifications.endpoints.smtp.SmtpClient;
import io.github.pve.client.resource.cluster.notifications.endpoints.webhook.WebhookClient;

/**
 * Client for /cluster/notifications/endpoints
 * BY '@xiao-rao'
 */
public class EndpointsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public EndpointsClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/notifications/endpoints";
    }

    /**
     * Index for all available endpoint types.
     */
    public List<Object> endpointsIndex() {
        PveResponse<List<Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `sendmail`
     */
    public SendmailClient sendmail() {
        return new SendmailClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `gotify`
     */
    public GotifyClient gotify() {
        return new GotifyClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `smtp`
     */
    public SmtpClient smtp() {
        return new SmtpClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `webhook`
     */
    public WebhookClient webhook() {
        return new WebhookClient(this.executor);
    }
}