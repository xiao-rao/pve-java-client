package io.github.pve.client.resource.cluster.base;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.exception.ProxmoxApiException;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import io.github.pve.client.model.cluster.acme.AcmeAccount;
import io.github.pve.client.model.cluster.acme.options.AcmeAccountCreationOrUpdateOptions;
import io.github.pve.client.model.cluster.acme.AcmePlugin;
import io.github.pve.client.model.cluster.acme.options.AcmePluginCreationOrUpdateOptions;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 管理 ACME (Let's Encrypt) 功能 - /cluster/acme
 */
public class AcmeResourceClient {

    private static final String BASE_PATH = "/cluster/acme";

    private final ProxmoxApiExecutor executor;

    public AcmeResourceClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
    }

    // --- /cluster/acme/account ---
    public List<AcmeAccount> listAccounts() {
        PveResponse<List<AcmeAccount>> response = executor.get(BASE_PATH + "/account", null, new TypeReference<>() {});
        return response.getData().orElse(Collections.emptyList());
    }

    public void createAccount(AcmeAccountCreationOrUpdateOptions options) {
        executor.post(BASE_PATH + "/account", null, options, new TypeReference<Void>() {});
    }

    // --- /cluster/acme/account/{name} ---
    public AcmeAccount getAccount(String name) {
        String path = BASE_PATH + "/account/" + name;
        PveResponse<AcmeAccount> response = executor.get(path, null, new TypeReference<>() {});
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Get ACME Account data is null", response.getStatusCode(), null, null, path));
    }

    public void updateAccount(String name, AcmeAccountCreationOrUpdateOptions options) {
        executor.put(BASE_PATH + "/account/" + name, null, options, new TypeReference<Void>() {});
    }

    public void deleteAccount(String name) {
        executor.delete(BASE_PATH + "/account/" + name, null, null, new TypeReference<Void>() {});
    }

    public String deactivateAccount(String name) {
        PveResponse<String> response = executor.post(BASE_PATH + "/account/" + name + "/deactivate", null, null, new TypeReference<>() {});
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Deactivate account UPID not returned", response.getStatusCode(), null, name, ""));
    }

    // --- /cluster/acme/tos ---
    public String getTermsOfServiceUrl(String directoryUrl) {
        Map<String, String> params = null;
        if (directoryUrl != null) {
            params = Collections.singletonMap("directory", directoryUrl);
        }
        PveResponse<String> response = executor.get(BASE_PATH + "/tos", params, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    // --- /cluster/acme/plugins ---
    public List<AcmePlugin> listPlugins() {
        PveResponse<List<AcmePlugin>> response = executor.get(BASE_PATH + "/plugins", null, new TypeReference<>() {});
        return response.getData().orElse(Collections.emptyList());
    }

    public void addPlugin(AcmePluginCreationOrUpdateOptions options) {
        executor.post(BASE_PATH + "/plugins", null, options, new TypeReference<Void>() {});
    }

    // --- /cluster/acme/plugins/{id} ---
    public AcmePlugin getPlugin(String id) {
        String path = BASE_PATH + "/plugins/" + id;
        PveResponse<AcmePlugin> response = executor.get(path, null, new TypeReference<>() {});
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Get ACME Plugin data is null", response.getStatusCode(), null, id, path));
    }

    public void updatePlugin(String id, AcmePluginCreationOrUpdateOptions options) {
        executor.put(BASE_PATH + "/plugins/" + id, null, options, new TypeReference<Void>() {});
    }

    public void deletePlugin(String id) {
        executor.delete(BASE_PATH + "/plugins/" + id, null, null, new TypeReference<Void>() {});
    }
}

