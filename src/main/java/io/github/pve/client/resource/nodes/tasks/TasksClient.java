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
    public NodeTasksResponse nodeTasks(String vmid, Boolean errors, Integer limit, Integer since, String source, Integer start, String statusfilter, String typefilter, Integer until, String userfilter) {
        String path = this.basePath + "/" + vmid;
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
        PveResponse<NodeTasksResponse> response = executor.get(path, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Stop a task.
     */
    public void stopTask(String upid) {
        executor.delete(this.basePath + "/" + upid);
    }

    /**
     * 
     */
    public void upidIndex(String upid) {
        executor.get(this.basePath + "/" + upid);
    }

    /**
     * Client for the specific `upid` resource.
     * @param upid The path parameter `upid`.
     */
    public LogClient log(String upid) {
        return new LogClient(this.executor, this.node, upid);
    }

    /**
     * Client for the specific `upid` resource.
     * @param upid The path parameter `upid`.
     */
    public StatusClient status(String upid) {
        return new StatusClient(this.executor, this.node, upid);
    }
}