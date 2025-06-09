package io.github.pve.client.resource.access.base;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.exception.ProxmoxApiException;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import io.github.pve.client.model.access.TfaChallenge;
import io.github.pve.client.model.access.TfaStatus;
import io.github.pve.client.resource.BaseResourceClient;


import java.util.HashMap;

import java.util.Map;

/**
 * 管理 PVE 用户的双因素认证 (/access/users/{userid}/tfa)
 */
public class TfaResourceClient extends BaseResourceClient {
    private String userId;

    public TfaResourceClient(ProxmoxApiExecutor executor) {
        super(executor);
    }

    void setUserId(String userId) {
        this.userId = userId;
    }

    private String getBasePath() {
        if (userId == null) throw new IllegalStateException("User ID not set for TfaResourceClient");
        return "/access/users/" + userId + "/tfa";
    }

    public TfaStatus getStatus()   {
        // The response is not wrapped in "data"
        PveResponse<TfaStatus> response = executor.get(getBasePath(), null, new TypeReference<>() {
        });
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Get TFA status data is null", response.getStatusCode(), null, null, getBasePath()));
    }

    public TfaChallenge addTotp(String description)   {
        String path = getBasePath();
        Map<String, String> params = new HashMap<>();
        params.put("type", "totp");
        if (description != null) {
            params.put("description", description);
        }
        PveResponse<TfaChallenge> response = executor.post(path, params, null, new TypeReference<>() {
        });
        return response.getData().orElseThrow(() -> new ProxmoxApiException("TFA challenge not returned", response.getStatusCode(), null, null, path));
    }

    public void verifyTotp(String totp, String challenge)   {
        String path = getBasePath();
        Map<String, String> params = new HashMap<>();
        params.put("code", totp);
        params.put("challenge", challenge);
        executor.put(path, null, params, new TypeReference<Void>() {
        });
    }

    public void delete(String tfaId, String password)   {
        String path = getBasePath() + "/" + tfaId;
        Map<String, String> params = new HashMap<>();
        params.put("password", password);
        executor.delete(path, params, null, new TypeReference<Void>() {
        });
    }
}

