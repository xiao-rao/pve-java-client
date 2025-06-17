package io.github.pve.client.resource.cluster.notifications.matcherfieldvalues;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

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
    public List<Object> getMatcherFieldValues() {
        PveResponse<List<Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}