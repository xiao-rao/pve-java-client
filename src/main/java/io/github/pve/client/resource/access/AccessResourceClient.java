package io.github.pve.client.resource.access;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.resource.access.base.*;
import io.github.pve.client.util.Lazy;

/**
 * 访问控制 (Access) 模块的总入口 Facade.
 * 严格按照PVE API文档的顶级分类聚合子客户端。
 */
public class AccessResourceClient {

    private final Lazy<AclResourceClient> aclClient;
    private final Lazy<DomainResourceClient> domainClient;
    private final Lazy<GroupResourceClient> groupClient;
    private final Lazy<OpenIdResourceClient> openIdClient;
    private final Lazy<PasswordResourceClient> passwordClient;
    private final Lazy<PermissionsResourceClient> permissionsClient;
    private final Lazy<RoleResourceClient> roleClient;
    private final Lazy<TfaResourceClient> tfaClient;
    private final Lazy<TicketResourceClient> ticketClient;
    private final Lazy<UserResourceClient> userClient;

    public AccessResourceClient(ProxmoxApiExecutor executor) {
        this.aclClient = new Lazy<>(() -> new AclResourceClient(executor));
        this.domainClient = new Lazy<>(() -> new DomainResourceClient(executor));
        this.groupClient = new Lazy<>(() -> new GroupResourceClient(executor));
        this.openIdClient = new Lazy<>(() -> new OpenIdResourceClient(executor));
        this.passwordClient = new Lazy<>(() -> new PasswordResourceClient(executor));
        this.permissionsClient = new Lazy<>(() -> new PermissionsResourceClient(executor));
        this.roleClient = new Lazy<>(() -> new RoleResourceClient(executor));
        this.tfaClient = new Lazy<>(() -> new TfaResourceClient(executor));
        this.ticketClient = new Lazy<>(() -> new TicketResourceClient(executor));
        this.userClient = new Lazy<>(() -> new UserResourceClient(executor));
    }

    public AclResourceClient acls() {
        return aclClient.get();
    }

    public DomainResourceClient domains() {
        return domainClient.get();
    }

    public GroupResourceClient groups() {
        return groupClient.get();
    }

    public OpenIdResourceClient openid() {
        return openIdClient.get();
    }

    public PasswordResourceClient password() {
        return passwordClient.get();
    }

    public PermissionsResourceClient permissions() {
        return permissionsClient.get();
    }

    public RoleResourceClient roles() {
        return roleClient.get();
    }

    public TfaResourceClient tfa() {
        return tfaClient.get();
    }

    public TicketResourceClient ticket() {
        return ticketClient.get();
    }

    public UserResourceClient users() {
        return userClient.get();
    }

}