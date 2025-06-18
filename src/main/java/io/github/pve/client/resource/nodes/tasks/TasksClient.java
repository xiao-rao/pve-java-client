package io.github.pve.client.resource.nodes.tasks;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.tasks.log.LogClient;
import io.github.pve.client.resource.nodes.tasks.status.StatusClient;
// Import models if needed
import io.github.pve.client.model.nodes.tasks.*;

/**
 * Client for /nodes/{node}/tasks
 * BY '@xiao-rao'
 */
public class TasksClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public TasksClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/tasks".replace("{" + "node" + "}", node);
    }

    /**
     * Read task list for one node (finished tasks).
     */
    public List<NodeTasksResponse> nodeTasks(String vmId, Boolean errors, Integer limit, Integer since, String source, Integer start, String statusfilter, String typefilter, Integer until, String userfilter) {
        String path = this.basePath + "/" + vmId;
        Map<String, Object> queryParams = new HashMap<>();
        if (errors != null) {
            queryParams.put("errors", errors);
        }
        if (limit != null) {
            queryParams.put("limit", limit);
        }
        if (since != null) {
            queryParams.put("since", since);
        }
        if (source != null) {
            queryParams.put("source", source);
        }
        if (start != null) {
            queryParams.put("start", start);
        }
        if (statusfilter != null) {
            queryParams.put("statusfilter", statusfilter);
        }
        if (typefilter != null) {
            queryParams.put("typefilter", typefilter);
        }
        if (until != null) {
            queryParams.put("until", until);
        }
        if (userfilter != null) {
            queryParams.put("userfilter", userfilter);
        }
        PveResponse<List<NodeTasksResponse>> response = executor.get(path, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Stop a task.
     */
    public void stopTask(String upId) {
        executor.delete(this.basePath + "/" + upId);
    }

    /**
     * 
     */
    public List<Object> upIdIndex(String upId) {
        PveResponse<List<Object>> response = executor.get(this.basePath + "/" + upId, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Client for the specific `upId` resource.
     * @param upId The path parameter `upId`.
     */
    public LogClient log(String upId) {
        return new LogClient(this.executor, this.node, upId);
    }

    /**
     * Client for the specific `upId` resource.
     * @param upId The path parameter `upId`.
     */
    public StatusClient status(String upId) {
        return new StatusClient(this.executor, this.node, upId);
    }
}