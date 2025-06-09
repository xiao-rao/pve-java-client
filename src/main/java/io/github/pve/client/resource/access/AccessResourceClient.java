package io.github.pve.client.resource.access;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.resource.BaseResourceClient;
import io.github.pve.client.resource.access.base.*;

/**
 * 访问控制 (Access) 模块的总入口 Facade.
 * 严格按照PVE API文档的顶级分类聚合子客户端。
 */
public class AccessResourceClient extends BaseResourceClient {

    private final AclResourceClient aclClient;
    private final DomainResourceClient domainClient;
    private final GroupResourceClient groupClient;
    private final OpenIdResourceClient openIdClient;
    private final PasswordResourceClient passwordClient;
    private final PermissionsResourceClient permissionsClient;
    private final RoleResourceClient roleClient;
    private final TfaResourceClient tfaClient;
    private final TicketResourceClient ticketClient;
    private final UserResourceClient userClient;

    public AccessResourceClient(ProxmoxApiExecutor executor) {
        super(executor);
        this.aclClient = new AclResourceClient(executor);
        this.domainClient = new DomainResourceClient(executor);
        this.groupClient = new GroupResourceClient(executor);
        this.openIdClient = new OpenIdResourceClient(executor);
        this.passwordClient = new PasswordResourceClient(executor);
        this.permissionsClient = new PermissionsResourceClient(executor);
        this.roleClient = new RoleResourceClient(executor);
        this.tfaClient = new TfaResourceClient(executor);
        this.ticketClient = new TicketResourceClient(executor);
        this.userClient = new UserResourceClient(executor);
    }

    public AclResourceClient acls() {
        return aclClient;
    }

    public DomainResourceClient domains() {
        return domainClient;
    }

    public GroupResourceClient groups() {
        return groupClient;
    }

    public OpenIdResourceClient openid() {
        return openIdClient;
    }

    public PasswordResourceClient password() {
        return passwordClient;
    }

    public PermissionsResourceClient permissions() {
        return permissionsClient;
    }

    public RoleResourceClient roles() {
        return roleClient;
    }

    public TfaResourceClient tfa() {
        return tfaClient;
    }

    public TicketResourceClient ticket() {
        return ticketClient;
    }

    public UserResourceClient users() {
        return userClient;
    }
}