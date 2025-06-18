package io.github.pve.client.resource.nodes.apt;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.apt.update.UpdateClient;
import io.github.pve.client.resource.nodes.apt.changelog.ChangelogClient;
import io.github.pve.client.resource.nodes.apt.repositories.RepositoriesClient;
import io.github.pve.client.resource.nodes.apt.versions.VersionsClient;
// Import models if needed
import io.github.pve.client.model.nodes.apt.*;

/**
 * Client for /nodes/{node}/apt
 * BY '@xiao-rao'
 */
public class AptClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public AptClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/apt".replace("{" + "node" + "}", node);
    }

    /**
     * Directory index for apt (Advanced Package Tool).
     */
    public List<NodesAptIndexResponse> index() {
        PveResponse<List<NodesAptIndexResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `update`
     */
    public UpdateClient update() {
        return new UpdateClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `changelog`
     */
    public ChangelogClient changelog() {
        return new ChangelogClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `repositories`
     */
    public RepositoriesClient repositories() {
        return new RepositoriesClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `versions`
     */
    public VersionsClient versions() {
        return new VersionsClient(this.executor, this.node);
    }
}