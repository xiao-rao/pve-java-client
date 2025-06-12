package io.github.pve.client.resource.access.base;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.exception.ProxmoxApiException;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import io.github.pve.client.model.access.AuthDomain;
import io.github.pve.client.model.access.options.AuthDomainCreationOrUpdateOptions;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 管理认证领域 (Authentication Domains) - /access/domains
 */
public class DomainResourceClient {

    private final ProxmoxApiExecutor executor;

    public DomainResourceClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
    }


    public List<AuthDomain> list() {
        PveResponse<List<AuthDomain>> response = executor.get("/access/domains", null, new TypeReference<>() {
        });
        return response.getData().orElse(Collections.emptyList());
    }

    public void create(AuthDomainCreationOrUpdateOptions options) {
        executor.post("/access/domains", null, options, new TypeReference<Void>() {
        });
    }


    public AuthDomain get(String realm) {
        String path = "/access/domains/" + realm;
        PveResponse<AuthDomain> response = executor.get(path, null, new TypeReference<>() {
        });
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Get AuthDomain data is null", response.getStatusCode(), null, null, path));
    }

    public void update( AuthDomainCreationOrUpdateOptions options)   {
        String path = "/access/domains/";
        executor.put(path, null, options, new TypeReference<Void>() {
        });
    }

    public void delete(String realm)   {
        String path = "/access/domains/" + realm;
        executor.delete(path, null, null, new TypeReference<Void>() {
        });
    }



    public String sync(String realm, AuthDomainCreationOrUpdateOptions options) throws Exception {
        Map<String, Object> params = options != null ? ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {
        }) : null;
        PveResponse<String> response = executor.post("/access/domains/" + realm + "/sync", null, params, new TypeReference<>() {
        });
        return response.getData().orElseThrow(() -> new Exception("Sync task UPID not returned"));
    }
}
