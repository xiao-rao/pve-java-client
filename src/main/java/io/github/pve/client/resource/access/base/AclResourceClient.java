package io.github.pve.client.resource.access.base;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import io.github.pve.client.model.access.Acl;
import io.github.pve.client.model.access.options.AclUpdateOptions;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 管理访问控制列表 (ACLs) - /access/acl
 */
public class AclResourceClient {

    private final ProxmoxApiExecutor executor;

    public AclResourceClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
    }

    public List<Acl> list() {
        PveResponse<List<Acl>> response = executor.get("/access/acl", null, new TypeReference<>() {});
        return response.getData().orElse(Collections.emptyList());
    }
    public void update(AclUpdateOptions options){
        Map<String, Object> params = ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {});
        executor.put("/access/acl", null, params, new TypeReference<Void>() {});
    }
}
