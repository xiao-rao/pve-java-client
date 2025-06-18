package io.github.pve.client.resource.cluster.notifications;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.cluster.notifications.matcherfields.MatcherFieldsClient;
import io.github.pve.client.resource.cluster.notifications.matcherfieldvalues.MatcherFieldValuesClient;
import io.github.pve.client.resource.cluster.notifications.endpoints.EndpointsClient;
import io.github.pve.client.resource.cluster.notifications.targets.TargetsClient;
import io.github.pve.client.resource.cluster.notifications.matchers.MatchersClient;

/**
 * Client for /cluster/notifications
 * BY '@xiao-rao'
 */
public class NotificationsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public NotificationsClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/notifications";
    }

    /**
     * Index for notification-related API endpoints.
     */
    public List<Object> index() {
        PveResponse<List<Object>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `matcherFields`
     */
    public MatcherFieldsClient matcherFields() {
        return new MatcherFieldsClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `matcherFieldValues`
     */
    public MatcherFieldValuesClient matcherFieldValues() {
        return new MatcherFieldValuesClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `endpoints`
     */
    public EndpointsClient endpoints() {
        return new EndpointsClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `targets`
     */
    public TargetsClient targets() {
        return new TargetsClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `matchers`
     */
    public MatchersClient matchers() {
        return new MatchersClient(this.executor);
    }
}