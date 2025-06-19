package io.github.pve.client.resource.nodes.replication.schedule_now;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/replication/{id}/schedule_now
 * BY '@xiao-rao'
 */
public class ScheduleNowClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String id;

    public ScheduleNowClient(ProxmoxApiExecutor executor, String node, String id) {
        this.executor = executor;
        this.node = node;
        this.id = id;
        this.basePath = "/nodes/{node}/replication/{id}/schedule_now".replace("{node}", node).replace("{id}", id);
    }

    /**
     * Schedule replication job to start as soon as possible.
     */
    public String scheduleNow() {
        PveResponse<String> response = executor.post(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}