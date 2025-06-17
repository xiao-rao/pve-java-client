package io.github.pve.client.resource.cluster.tasks;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /cluster/tasks
 * BY '@xiao-rao'
 */
public class TasksClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public TasksClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/tasks";
    }

    /**
     * List recent tasks (cluster wide).
     */
    public List<Object> tasks() {
        PveResponse<List<Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}