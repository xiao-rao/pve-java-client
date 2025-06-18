package io.github.pve.client.resource.cluster.notifications.matcherfields;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.notifications.matcherfields.*;

/**
 * Client for /cluster/notifications/matcher-fields
 * BY '@xiao-rao'
 */
public class MatcherFieldsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public MatcherFieldsClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/notifications/matcher-fields";
    }

    /**
     * Returns known notification metadata fields
     */
    public List<GetMatcherFieldsResponse> getMatcherFields() {
        PveResponse<List<GetMatcherFieldsResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}