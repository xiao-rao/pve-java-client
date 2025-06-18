package io.github.pve.client.resource.access.domains;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.access.domains.sync.SyncClient;
// Import models if needed
import io.github.pve.client.model.access.domains.*;

/**
 * Client for /access/domains
 * BY '@xiao-rao'
 */
public class DomainsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public DomainsClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/access/domains";
    }

    /**
     * Authentication domain index.
     */
    public List<AccessDomainsIndexResponse> index() {
        PveResponse<List<AccessDomainsIndexResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Add an authentication server.
     */
    public void create(CreateRequest request) {
        executor.post(this.basePath, request);
    }

    /**
     * Delete an authentication server.
     */
    public void delete(String realm) {
        executor.delete(this.basePath + "/" + realm);
    }

    /**
     * Get auth server configuration.
     */
    public void read(String realm) {
        executor.get(this.basePath + "/" + realm);
    }

    /**
     * Update authentication server settings.
     */
    public void update(UpdateRequest request) {
        executor.put(this.basePath + "/" + request.getRealm(), request);
    }

    /**
     * Client for the specific `realm` resource.
     * @param realm The path parameter `realm`.
     */
    public SyncClient sync(String realm) {
        return new SyncClient(this.executor, realm);
    }
}