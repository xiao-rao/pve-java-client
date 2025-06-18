package io.github.pve.client.resource.access;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.access.users.UsersClient;
import io.github.pve.client.resource.access.groups.GroupsClient;
import io.github.pve.client.resource.access.roles.RolesClient;
import io.github.pve.client.resource.access.acl.AclClient;
import io.github.pve.client.resource.access.domains.DomainsClient;
import io.github.pve.client.resource.access.openid.OpenidClient;
import io.github.pve.client.resource.access.tfa.TfaClient;
import io.github.pve.client.resource.access.ticket.TicketClient;
import io.github.pve.client.resource.access.password.PasswordClient;
import io.github.pve.client.resource.access.permissions.PermissionsClient;
// Import models if needed
import io.github.pve.client.model.access.*;

/**
 * Client for /access
 * BY '@xiao-rao'
 */
public class AccessClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public AccessClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/access";
    }

    /**
     * Directory index.
     */
    public List<AccessIndexResponse> index() {
        PveResponse<List<AccessIndexResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `users`
     */
    public UsersClient users() {
        return new UsersClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `groups`
     */
    public GroupsClient groups() {
        return new GroupsClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `roles`
     */
    public RolesClient roles() {
        return new RolesClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `acl`
     */
    public AclClient acl() {
        return new AclClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `domains`
     */
    public DomainsClient domains() {
        return new DomainsClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `openId`
     */
    public OpenidClient openId() {
        return new OpenidClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `tfa`
     */
    public TfaClient tfa() {
        return new TfaClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `ticket`
     */
    public TicketClient ticket() {
        return new TicketClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `password`
     */
    public PasswordClient password() {
        return new PasswordClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `permissions`
     */
    public PermissionsClient permissions() {
        return new PermissionsClient(this.executor);
    }
}