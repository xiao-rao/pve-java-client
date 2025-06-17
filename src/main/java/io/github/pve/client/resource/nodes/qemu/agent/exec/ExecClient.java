package io.github.pve.client.resource.nodes.qemu.agent.exec;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/qemu/{vmid}/agent/exec
 * BY '@xiao-rao'
 */
public class ExecClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public ExecClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/qemu/{vmid}/agent/exec".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Executes the given command in the vm via the guest-agent and returns an object with the pid.
     */
    public Object exec(List<Object> command, String inputData) {
        Map<String, Object> options = new HashMap<>();
        if (command != null) {
            options.put("command", command);
        }
        if (inputData != null) {
            options.put("input-data", inputData);
        }
        PveResponse<Object> response = executor.post(this.basePath, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}