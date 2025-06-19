package io.github.pve.client.resource.access.domains.sync;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.access.domains.sync.*;

/**
 * Client for /access/domains/{realm}/sync
 * BY '@xiao-rao'
 */
public class SyncClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String realm;

    public SyncClient(ProxmoxApiExecutor executor, String realm) {
        this.executor = executor;
        this.realm = realm;
        this.basePath = "/access/domains/{realm}/sync".replace("{realm}", realm);
    }

    /**
     * Syncs users and/or groups from the configured LDAP to user.cfg. NOTE: Synced groups will have the name 'name-$realm', so make sure those groups do not exist to prevent overwriting.
     */
    public String sync(SyncRequest request) {
        PveResponse<String> response = executor.post(this.basePath, request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}