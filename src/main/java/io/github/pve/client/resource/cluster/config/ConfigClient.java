package io.github.pve.client.resource.cluster.config;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.cluster.config.apiversion.ApiversionClient;
import io.github.pve.client.resource.cluster.config.nodes.NodesClient;
import io.github.pve.client.resource.cluster.config.join.JoinClient;
import io.github.pve.client.resource.cluster.config.totem.TotemClient;
import io.github.pve.client.resource.cluster.config.qdevice.QdeviceClient;
// Import models if needed
import io.github.pve.client.model.cluster.config.*;

/**
 * Client for /cluster/config
 * BY '@xiao-rao'
 */
public class ConfigClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public ConfigClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/config";
    }

    /**
     * Directory index.
     */
    public List<Object> index() {
        PveResponse<List<Object>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Generate new cluster configuration. If no links given, default to local IP address as link0.
     */
    public String create(CreateRequest request) {
        PveResponse<String> response = executor.post(this.basePath, request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `apiversion`
     */
    public ApiversionClient apiversion() {
        return new ApiversionClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `nodes`
     */
    public NodesClient nodes() {
        return new NodesClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `join`
     */
    public JoinClient join() {
        return new JoinClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `totem`
     */
    public TotemClient totem() {
        return new TotemClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `qdevice`
     */
    public QdeviceClient qdevice() {
        return new QdeviceClient(this.executor);
    }
}