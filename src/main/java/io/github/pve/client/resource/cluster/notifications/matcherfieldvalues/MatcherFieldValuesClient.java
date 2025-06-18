package io.github.pve.client.resource.cluster.notifications.matcherfieldvalues;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.notifications.matcherfieldvalues.*;

/**
 * Client for /cluster/notifications/matcher-field-values
 * BY '@xiao-rao'
 */
public class MatcherFieldValuesClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public MatcherFieldValuesClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/notifications/matcher-field-values";
    }

    /**
     * Returns known notification metadata fields and their known values
     */
    public List<GetMatcherFieldValuesResponse> getMatcherFieldValues() {
        PveResponse<List<GetMatcherFieldValuesResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}