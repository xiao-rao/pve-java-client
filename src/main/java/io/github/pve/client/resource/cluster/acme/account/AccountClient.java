package io.github.pve.client.resource.cluster.acme.account;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.acme.account.*;

/**
 * Client for /cluster/acme/account
 * BY '@xiao-rao'
 */
public class AccountClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public AccountClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/acme/account";
    }

    /**
     * ACMEAccount index.
     */
    public List<Object> accountIndex() {
        PveResponse<List<Object>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Register a new ACME account with CA.
     */
    public String registerAccount(RegisterAccountRequest request) {
        PveResponse<String> response = executor.post(this.basePath, request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Deactivate existing ACME account at CA.
     */
    public String deactivateAccount(String name) {
        PveResponse<String> response = executor.delete(this.basePath + "/" + name, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Return existing ACME account information.
     */
    public GetAccountResponse getAccount(String name) {
        PveResponse<GetAccountResponse> response = executor.get(this.basePath + "/" + name, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Update existing ACME account information with CA. Note: not specifying any new account information triggers a refresh.
     */
    public String updateAccount(String name, String contact) {
        String path = this.basePath + "/" + name;
        Map<String, Object> options = new HashMap<>();
        if (contact != null) {
            options.put("contact", contact);
        }
        PveResponse<String> response = executor.put(path, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}