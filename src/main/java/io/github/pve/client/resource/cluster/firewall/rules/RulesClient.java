package io.github.pve.client.resource.cluster.firewall.rules;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.firewall.rules.*;

/**
 * Client for /cluster/firewall/rules
 * BY '@xiao-rao'
 */
public class RulesClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public RulesClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/firewall/rules";
    }

    /**
     * List rules.
     */
    public List<GetRulesResponse> getRules() {
        PveResponse<List<GetRulesResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create new rule.
     */
    public void createRule(CreateRuleRequest request) {
        executor.post(this.basePath, request);
    }

    /**
     * Delete rule.
     */
    public void deleteRule(String pos, String digest) {
        String path = this.basePath + "/" + pos;
        Map<String, Object> options = new HashMap<>();
        if (digest != null) {
            options.put("digest", digest);
        }
        executor.delete(path, options);
    }

    /**
     * Get single rule data.
     */
    public GetRuleResponse getRule(String pos) {
        PveResponse<GetRuleResponse> response = executor.get(this.basePath + "/" + pos, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Modify rule data.
     */
    public void updateRule(UpdateRuleRequest request) {
        executor.put(this.basePath + "/" + request.getPos(), request);
    }
}