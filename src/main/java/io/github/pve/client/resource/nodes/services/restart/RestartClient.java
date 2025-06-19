package io.github.pve.client.resource.nodes.services.restart;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/services/{service}/restart
 * BY '@xiao-rao'
 */
public class RestartClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String service;

    public RestartClient(ProxmoxApiExecutor executor, String node, String service) {
        this.executor = executor;
        this.node = node;
        this.service = service;
        this.basePath = "/nodes/{node}/services/{service}/restart".replace("{node}", node).replace("{service}", service);
    }

    /**
     * Hard restart service. Use reload if you want to reduce interruptions.
     */
    public String serviceRestart() {
        PveResponse<String> response = executor.post(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}