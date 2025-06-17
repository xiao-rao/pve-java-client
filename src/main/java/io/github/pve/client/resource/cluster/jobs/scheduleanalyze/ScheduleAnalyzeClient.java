package io.github.pve.client.resource.cluster.jobs.scheduleanalyze;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /cluster/jobs/schedule-analyze
 * BY '@xiao-rao'
 */
public class ScheduleAnalyzeClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public ScheduleAnalyzeClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/jobs/schedule-analyze";
    }

    /**
     * Returns a list of future schedule runtimes.
     */
    public List<Object> scheduleAnalyze(Integer iterations, String schedule, Integer starttime) {
        Map<String, Object> queryParams = new HashMap<>();
        if (iterations != null) {
            queryParams.put("iterations", iterations);
        }
        if (schedule != null) {
            queryParams.put("schedule", schedule);
        }
        if (starttime != null) {
            queryParams.put("starttime", starttime);
        }
        PveResponse<List<Object>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}