package io.github.pve.client.resource;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.exception.ProxmoxApiException;
import io.github.pve.client.exception.ProxmoxAuthException;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import io.github.pve.client.model.common.TaskStatusInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 基础资源客户端，共享 ProxmoxApiExecutor 并提供通用方法。
 */
public abstract class BaseResourceClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseResourceClient.class);
    private static final Pattern UPID_NODE_PATTERN = Pattern.compile("UPID:([^:]+):.*");
    protected final ProxmoxApiExecutor executor;

    protected BaseResourceClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
    }

    /**
     * 从UPID字符串中解析出节点名。
     * UPID format: UPID:<nodename>:<pid_hex>:<pstart_hex>:<taskid_hex>:<starttime_hex>:<type>:<id>:<user>:
     *
     * @param upid The UPID string.
     * @return The node name.
     * @throws IllegalArgumentException if the UPID format is invalid.
     */
    protected String parseNodeFromUpid(String upid) {
        if (upid == null || upid.isEmpty()) {
            throw new IllegalArgumentException("UPID cannot be null or empty.");
        }
        Matcher matcher = UPID_NODE_PATTERN.matcher(upid);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid UPID format: " + upid);
    }

    /**
     * 等待异步任务完成。该方法会自动从UPID中解析出节点名。
     *
     * @param upid               任务UPID
     * @param timeoutSeconds     超时时间（秒）
     * @param pollIntervalMillis 轮询间隔（毫秒）
     * @return 最终的任务状态
     * @throws ProxmoxApiException  如果任务失败或超时
     * @throws InterruptedException 如果线程被中断
     * @throws ProxmoxAuthException 如果认证失败
     */
    public TaskStatusInfo waitForTaskCompletion(String upid, long timeoutSeconds, long pollIntervalMillis)
            throws ProxmoxApiException, InterruptedException, ProxmoxAuthException {

        String pveNodeName = parseNodeFromUpid(upid);
        long startTime = System.currentTimeMillis();
        long timeoutMillis = TimeUnit.SECONDS.toMillis(timeoutSeconds);

        while (System.currentTimeMillis() - startTime < timeoutMillis) {
            String taskPath = String.format("/nodes/%s/tasks/%s/status", pveNodeName, upid);
            PveResponse<TaskStatusInfo> response = executor.get(taskPath, null, new TypeReference<>() {
            });

            TaskStatusInfo statusInfo = response.getData().orElseThrow(() ->
                    new ProxmoxApiException("Task status response was empty for UPID: " + upid,
                            response.getStatusCode(), null, pveNodeName, taskPath));

            if ("stopped" .equalsIgnoreCase(statusInfo.getStatus())) {
                if ("OK" .equalsIgnoreCase(statusInfo.getExitstatus())) {
                    LOGGER.info("Task {} on node {} completed successfully.", upid, pveNodeName);
                    return statusInfo;
                } else {
                    String errorMessage = String.format("Task %s on node %s completed with error: %s",
                            upid, pveNodeName, statusInfo.getExitstatus());
                    LOGGER.error(errorMessage);
                    // 可以考虑在这里获取任务日志以获得更详细的错误信息
                    throw new ProxmoxApiException(errorMessage, response.getStatusCode(), null, pveNodeName, taskPath);
                }
            }
            LOGGER.debug("Task {} on node {} is still {}. Waiting...", upid, pveNodeName, statusInfo.getStatus());
            Thread.sleep(pollIntervalMillis);
        }
        String timeoutMessage = String.format("Timeout waiting for task %s on node %s to complete.", upid, pveNodeName);
        throw new ProxmoxApiException(timeoutMessage,
                -1, null, pveNodeName, String.format("/nodes/%s/tasks/%s/status", pveNodeName, upid));
    }
}

