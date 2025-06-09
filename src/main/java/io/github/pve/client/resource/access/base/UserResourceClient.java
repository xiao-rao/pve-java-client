package io.github.pve.client.resource.access.base;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.exception.ProxmoxApiException;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import io.github.pve.client.model.access.*;
import io.github.pve.client.model.access.options.ApiTokenCreationOptions;
import io.github.pve.client.model.access.options.UserCreationOrUpdateOptions;
import io.github.pve.client.resource.BaseResourceClient;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 管理 PVE 用户 (/access/users) 及其所有子资源.
 */
public class UserResourceClient extends BaseResourceClient {

    public UserResourceClient(ProxmoxApiExecutor executor) {
        super(executor);
    }

    // --- /access/users ---
    public List<User> list()   {
        PveResponse<List<User>> response = executor.get("/access/users", null, new TypeReference<>() {
        });
        return response.getData().orElse(Collections.emptyList());
    }

    public void create(String userId, UserCreationOrUpdateOptions options)   {
        String path = "/access/users";
        Map<String, Object> params = ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {
        });
        params.put("userid", userId);
        executor.post(path, null, params, new TypeReference<Void>() {
        });
    }

    // --- /access/users/{userid} ---
    public User get(String userId)   {
        String path = "/access/users/" + userId;
        PveResponse<User> response = executor.get(path, null, new TypeReference<>() {
        });
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Get User data is null", response.getStatusCode(), null, null, path));
    }

    public void update(String userId, UserCreationOrUpdateOptions options)   {
        String path = "/access/users/" + userId;
        Map<String, Object> params = ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {
        });
        executor.put(path, null, params, new TypeReference<Void>() {
        });
    }

    public void delete(String userId)   {
        String path = "/access/users/" + userId;
        executor.delete(path, null, null, new TypeReference<Void>() {
        });
    }

    // --- /access/users/{userid}/token ---
    public List<ApiToken> listTokens(String userId)   {
        String path = "/access/users/" + userId + "/token";
        PveResponse<List<ApiToken>> response = executor.get(path, null, new TypeReference<>() {
        });
        return response.getData().orElse(Collections.emptyList());
    }

    public ApiTokenSecret createToken(String userId, String tokenId, ApiTokenCreationOptions options)   {
        String path = "/access/users/" + userId + "/token/" + tokenId;
        Map<String, Object> params = options != null ? ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {
        }) : Collections.emptyMap();
        PveResponse<ApiTokenSecret> response = executor.post(path, null, params, new TypeReference<>() {
        });
        return response.getData().orElseThrow(() -> new ProxmoxApiException("API token secret not returned", response.getStatusCode(), null, null, path));
    }

    public ApiToken getToken(String userId, String tokenId)   {
        String path = "/access/users/" + userId + "/token/" + tokenId;
        PveResponse<ApiToken> response = executor.get(path, null, new TypeReference<>() {
        });
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Get API Token data is null", response.getStatusCode(), null, null, path));
    }

    public void updateToken(String userId, String tokenId, ApiTokenCreationOptions options)   {
        String path = "/access/users/" + userId + "/token/" + tokenId;
        Map<String, Object> params = ProxmoxApiExecutor.getObjectMapper().convertValue(options, new TypeReference<>() {
        });
        executor.put(path, null, params, new TypeReference<Void>() {
        });
    }

    public void deleteToken(String userId, String tokenId)   {
        String path = "/access/users/" + userId + "/token/" + tokenId;
        executor.delete(path, null, null, new TypeReference<Void>() {
        });
    }

    // --- /access/users/{userid}/tfa ---
    public TfaStatus getTfa(String userId, Boolean multiple)   {
        String path = "/access/users/" + userId + "/tfa";
        PveResponse<TfaStatus> response = executor.get(path, null, new TypeReference<>() {
        });
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Get TFA status data is null", response.getStatusCode(), null, null, path));
    }

    // --- /access/users/{userid}/unlock-tfa ---
    public void unlockTfa(String userId)   {
        String path = "/access/users/" + userId + "/unlock-tfa";
        executor.get(path, null, new TypeReference<Void>() {
        });
    }
}
