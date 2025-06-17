package io.github.pve.client.resource.cluster.firewall.groups;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.firewall.groups.*;

/**
 * Client for /cluster/firewall/groups
 * BY '@xiao-rao'
 */
public class GroupsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public GroupsClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/firewall/groups";
    }

    /**
     * List security groups.
     */
    public List<Object> listSecurityGroups() {
        PveResponse<List<Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create new security group.
     */
    public void createSecurityGroup(CreateSecurityGroupRequest request) {
        executor.post(this.basePath, request);
    }

    /**
     * Delete security group.
     */
    public void deleteSecurityGroup(String group) {
        executor.delete(this.basePath + "/" + group);
    }

    /**
     * List rules.
     */
    public void getRules(String group) {
        executor.get(this.basePath + "/" + group);
    }

    /**
     * Create new rule.
     */
    public void createRule(CreateRuleRequest request) {
        executor.post(this.basePath + "/" + request.getGroup(), request);
    }

    /**
     * Delete rule.
     */
    public void deleteRule(String pos, String group, String digest) {
        String path = this.basePath + "/" + group;
        path = path + "/" + pos;
        Map<String, Object> options = new HashMap<>();
        if (digest != null) {
            options.put("digest", digest);
        }
        executor.delete(path, options);
    }

    /**
     * Get single rule data.
     */
    public GetRuleResponse getRule(String pos, String group) {
        PveResponse<GetRuleResponse> response = executor.get(this.basePath + "/" + group + "/" + pos, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Modify rule data.
     */
    public void updateRule(UpdateRuleRequest request) {
        executor.put(this.basePath + "/" + request.getGroup() + "/" + request.getPos(), request);
    }
}