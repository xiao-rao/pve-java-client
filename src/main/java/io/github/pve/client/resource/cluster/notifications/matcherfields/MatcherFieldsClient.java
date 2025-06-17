package io.github.pve.client.resource.cluster.notifications.matcherfields;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

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
    public List<Object> getMatcherFields() {
        PveResponse<List<Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}