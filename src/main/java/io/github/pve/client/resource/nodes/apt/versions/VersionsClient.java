package io.github.pve.client.resource.nodes.apt.versions;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/apt/versions
 * BY '@xiao-rao'
 */
public class VersionsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public VersionsClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/apt/versions".replace("{node}", node);
    }

    /**
     * Get package information for important Proxmox packages.
     */
    public List<Object> versions() {
        PveResponse<List<Object>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}