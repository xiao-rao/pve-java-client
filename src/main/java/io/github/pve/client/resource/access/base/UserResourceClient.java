package io.github.pve.client.resource.access.base;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.exception.ProxmoxApiException;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import io.github.pve.client.model.access.*;
import io.github.pve.client.model.access.options.ApiTokenCreationOptions;
import io.github.pve.client.model.access.options.UserCreationOrUpdateOptions;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 管理 PVE 用户 (/access/users) 及其所有子资源.
 */
public class UserResourceClient {

    private final ProxmoxApiExecutor executor;

    public UserResourceClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
    }


    // --- /access/users ---
    public List<User> list() {
        PveResponse<List<User>> response = executor.get("/access/users", null, new TypeReference<>() {
        });
        return response.getData().orElse(Collections.emptyList());
    }

    public void create(UserCreationOrUpdateOptions options) {
        String path = "/access/users";
        executor.post(path, null, options, new TypeReference<Void>() {
        });
    }

    // --- /access/users/{userid} ---
    public User get(String userId) {
        String path = "/access/users/" + userId;
        PveResponse<User> response = executor.get(path, null, new TypeReference<>() {
        });
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Get User data is null", response.getStatusCode(), null, null, path));
    }

    public void update(UserCreationOrUpdateOptions options) {
        String path = "/access/users/" + options.getUserId();
        Map<String, Object> params = ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {
        });
        executor.put(path, null, params, new TypeReference<Void>() {
        });
    }

    public void delete(String userId) {
        String path = "/access/users/" + userId;
        executor.delete(path, null, null, new TypeReference<Void>() {
        });
    }

    // --- /access/users/{userid}/token ---
    public List<ApiToken> listTokens(String userId) {
        String path = "/access/users/" + userId + "/token";
        PveResponse<List<ApiToken>> response = executor.get(path, null, new TypeReference<>() {
        });
        return response.getData().orElse(Collections.emptyList());
    }

    public ApiTokenSecret createToken(ApiTokenCreationOptions options) {
        String path = "/access/users/" + options.getUserId() + "/token/" + options.getTokenId();
        PveResponse<ApiTokenSecret> response = executor.post(path, null, options, new TypeReference<>() {
        });
        return response.getData().orElseThrow(() -> new ProxmoxApiException("API token secret not returned", response.getStatusCode(), null, null, path));
    }

    public ApiToken getToken(String userId, String tokenId) {
        String path = "/access/users/" + userId + "/token/" + tokenId;
        PveResponse<ApiToken> response = executor.get(path, null, new TypeReference<>() {
        });
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Get API Token data is null", response.getStatusCode(), null, null, path));
    }

    public void updateToken(ApiTokenCreationOptions options) {
        String path = "/access/users/" + options.getUserId() + "/token/" + options.getTokenId();
        executor.put(path, null, options, new TypeReference<Void>() {
        });
    }

    public void deleteToken(String userId, String tokenId) {
        String path = "/access/users/" + userId + "/token/" + tokenId;
        executor.delete(path, null, null, new TypeReference<Void>() {
        });
    }

    // --- /access/users/{userid}/tfa ---
    public TfaStatus getTfa(String userId, Boolean multiple) {
        String path = "/access/users/" + userId + "/tfa";
        if (multiple != null) {
            path = multiple ? path + "?multiple=1" : path + "?multiple=0";
        }
        PveResponse<TfaStatus> response = executor.get(path, null, new TypeReference<>() {
        });
        String finalPath = path;
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Get TFA status data is null", response.getStatusCode(), null, null, finalPath));
    }

    // --- /access/users/{userid}/unlock-tfa ---
    public void unlockTfa(String userId) {
        String path = "/access/users/" + userId + "/unlock-tfa";
        executor.get(path, null, new TypeReference<Void>() {
        });
    }
}
