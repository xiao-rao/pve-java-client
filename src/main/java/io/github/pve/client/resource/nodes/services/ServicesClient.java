package io.github.pve.client.resource.nodes.services;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.services.state.StateClient;
import io.github.pve.client.resource.nodes.services.start.StartClient;
import io.github.pve.client.resource.nodes.services.stop.StopClient;
import io.github.pve.client.resource.nodes.services.restart.RestartClient;
import io.github.pve.client.resource.nodes.services.reload.ReloadClient;
// Import models if needed
import io.github.pve.client.model.nodes.services.*;

/**
 * Client for /nodes/{node}/services
 * BY '@xiao-rao'
 */
public class ServicesClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public ServicesClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/services".replace("{" + "node" + "}", node);
    }

    /**
     * Service list.
     */
    public List<Object> index() {
        PveResponse<List<Object>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Directory index
     */
    public List<SrvcmdidxResponse> srvcmdidx(String service) {
        PveResponse<List<SrvcmdidxResponse>> response = executor.get(this.basePath + "/" + service, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Client for the specific `service` resource.
     * @param service The path parameter `service`.
     */
    public StateClient state(String service) {
        return new StateClient(this.executor, this.node, service);
    }

    /**
     * Client for the specific `service` resource.
     * @param service The path parameter `service`.
     */
    public StartClient start(String service) {
        return new StartClient(this.executor, this.node, service);
    }

    /**
     * Client for the specific `service` resource.
     * @param service The path parameter `service`.
     */
    public StopClient stop(String service) {
        return new StopClient(this.executor, this.node, service);
    }

    /**
     * Client for the specific `service` resource.
     * @param service The path parameter `service`.
     */
    public RestartClient restart(String service) {
        return new RestartClient(this.executor, this.node, service);
    }

    /**
     * Client for the specific `service` resource.
     * @param service The path parameter `service`.
     */
    public ReloadClient reload(String service) {
        return new ReloadClient(this.executor, this.node, service);
    }
}