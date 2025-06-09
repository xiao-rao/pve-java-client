package io.github.pve.client.resource.version;


import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.exception.ProxmoxApiException;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import io.github.pve.client.model.version.Version;
import io.github.pve.client.resource.BaseResourceClient;

/**
 * 获取版本信息 - /version
 */
public class VersionResourceClient extends BaseResourceClient {

    public VersionResourceClient(ProxmoxApiExecutor executor) {
        super(executor);
    }

    public Version get()   {
        String path = "/version";
        PveResponse<Version> response = executor.get(path, null, new TypeReference<>() {
        });
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Get Version data is null", response.getStatusCode(), null, null, path));
    }
}
