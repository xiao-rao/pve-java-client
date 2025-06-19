package io.github.pve.client.resource.nodes.qemu.firewall.aliases;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.qemu.firewall.aliases.*;

/**
 * Client for /nodes/{node}/qemu/{vmid}/firewall/aliases
 * BY '@xiao-rao'
 */
public class AliasesClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public AliasesClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/qemu/{vmid}/firewall/aliases".replace("{node}", node).replace("{vmid}", vmId);
    }

    /**
     * List aliases
     */
    public List<GetAliasesResponse> getAliases() {
        PveResponse<List<GetAliasesResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
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
    public Map<String, Object> readAlias(String name) {
        PveResponse<Map<String, Object>> response = executor.get(this.basePath + "/" + name, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Update IP or Network alias.
     */
    public void updateAlias(UpdateAliasRequest request) {
        executor.put(this.basePath + "/" + request.getName(), request);
    }
}