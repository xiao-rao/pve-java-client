package io.github.pve.client.resource.cluster.config.qdevice;

import java.util.Map;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /cluster/config/qdevice
 * BY '@xiao-rao'
 */
public class QdeviceClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public QdeviceClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/config/qdevice";
    }

    /**
     * Get QDevice status
     */
    public Map<String, Object> status() {
        PveResponse<Map<String, Object>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}