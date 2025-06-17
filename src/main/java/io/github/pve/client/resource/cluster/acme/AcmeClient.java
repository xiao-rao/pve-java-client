package io.github.pve.client.resource.cluster.acme;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.cluster.acme.plugins.PluginsClient;
import io.github.pve.client.resource.cluster.acme.account.AccountClient;
import io.github.pve.client.resource.cluster.acme.tos.TosClient;
import io.github.pve.client.resource.cluster.acme.meta.MetaClient;
import io.github.pve.client.resource.cluster.acme.directories.DirectoriesClient;
import io.github.pve.client.resource.cluster.acme.challengeschema.ChallengeSchemaClient;

/**
 * Client for /cluster/acme
 * BY '@xiao-rao'
 */
public class AcmeClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public AcmeClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/acme";
    }

    /**
     * ACMEAccount index.
     */
    public List<Object> index() {
        PveResponse<List<Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `plugins`
     */
    public PluginsClient plugins() {
        return new PluginsClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `account`
     */
    public AccountClient account() {
        return new AccountClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `tos`
     */
    public TosClient tos() {
        return new TosClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `meta`
     */
    public MetaClient meta() {
        return new MetaClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `directories`
     */
    public DirectoriesClient directories() {
        return new DirectoriesClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `challengeSchema`
     */
    public ChallengeSchemaClient challengeSchema() {
        return new ChallengeSchemaClient(this.executor);
    }
}