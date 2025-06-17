package io.github.pve.client.resource.nodes.replication;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.replication.status.StatusClient;
import io.github.pve.client.resource.nodes.replication.log.LogClient;
import io.github.pve.client.resource.nodes.replication.schedule_now.ScheduleNowClient;

/**
 * Client for /nodes/{node}/replication
 * BY '@xiao-rao'
 */
public class ReplicationClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public ReplicationClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/replication".replace("{" + "node" + "}", node);
    }

    /**
     * List status of all replication jobs on this node.
     */
    public List<Object> status(Integer guest) {
        Map<String, Object> queryParams = new HashMap<>();
        if (guest != null) {
            queryParams.put("guest", guest);
        }
        PveResponse<List<Object>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Directory index.
     */
    public void index(String id) {
        executor.get(this.basePath + "/" + id);
    }

    /**
     * Client for the specific `id` resource.
     * @param id The path parameter `id`.
     */
    public StatusClient status(String id) {
        return new StatusClient(this.executor, this.node, id);
    }

    /**
     * Client for the specific `id` resource.
     * @param id The path parameter `id`.
     */
    public LogClient log(String id) {
        return new LogClient(this.executor, this.node, id);
    }

    /**
     * Client for the specific `id` resource.
     * @param id The path parameter `id`.
     */
    public ScheduleNowClient scheduleNow(String id) {
        return new ScheduleNowClient(this.executor, this.node, id);
    }
}