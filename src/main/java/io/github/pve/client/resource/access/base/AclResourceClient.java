package io.github.pve.client.resource.access.base;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import io.github.pve.client.model.access.Acl;
import io.github.pve.client.model.access.options.AclUpdateOptions;
import io.github.pve.client.resource.BaseResourceClient;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 管理访问控制列表 (ACLs) - /access/acl
 */
public class AclResourceClient extends BaseResourceClient {

    public AclResourceClient(ProxmoxApiExecutor executor) {
        super(executor);
    }

    public List<Acl> list() throws Exception {
        PveResponse<List<Acl>> response = executor.get("/access/acl", null, new TypeReference<>() {});
        return response.getData().orElse(Collections.emptyList());
    }
    public void update(AclUpdateOptions options) throws Exception {
        Map<String, Object> params = ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {});
        executor.put("/access/acl", null, params, new TypeReference<Void>() {});
    }
}
