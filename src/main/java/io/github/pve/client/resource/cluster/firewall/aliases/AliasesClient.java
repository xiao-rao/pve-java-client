package io.github.pve.client.resource.cluster.firewall.aliases;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.firewall.aliases.*;

/**
 * Client for /cluster/firewall/aliases
 * BY '@xiao-rao'
 */
public class AliasesClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public AliasesClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/firewall/aliases";
    }

    /**
     * List aliases
     */
    public GetAliasesResponse getAliases() {
        PveResponse<GetAliasesResponse> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create IP or Network Alias.
     */
    public void createAlias(CreateAliasRequest request) {
        executor.post(this.basePath, request);
    }

    /**
     * Remove IP or Network alias.
     */
    public void removeAlias(String name, String digest) {
        String path = this.basePath + "/" + name;
        Map<String, Object> options = new HashMap<>();
        if (digest != null) {
            options.put("digest", digest);
        }
        executor.delete(path, options);
    }

    /**
     * Read alias.
     */
    public void readAlias(String name) {
        executor.get(this.basePath + "/" + name);
    }

    /**
     * Update IP or Network alias.
     */
    public void updateAlias(UpdateAliasRequest request) {
        executor.put(this.basePath + "/" + request.getName(), request);
    }
}