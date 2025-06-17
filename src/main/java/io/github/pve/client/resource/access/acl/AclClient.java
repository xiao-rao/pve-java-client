package io.github.pve.client.resource.access.acl;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.access.acl.*;

/**
 * Client for /access/acl
 * BY '@xiao-rao'
 */
public class AclClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public AclClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/access/acl";
    }

    /**
     * Get Access Control List (ACLs).
     */
    public ReadAclResponse readAcl() {
        PveResponse<ReadAclResponse> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Update Access Control List (add or remove permissions).
     */
    public void updateAcl(UpdateAclRequest request) {
        executor.put(this.basePath, request);
    }
}