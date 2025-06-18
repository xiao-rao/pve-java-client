package io.github.pve.client.resource.nodes.qemu.agent.setuserpassword;

import java.util.Map;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.qemu.agent.setuserpassword.*;

/**
 * Client for /nodes/{node}/qemu/{vmid}/agent/set-user-password
 * BY '@xiao-rao'
 */
public class SetUserPasswordClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public SetUserPasswordClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/qemu/{vmid}/agent/set-user-password".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmId);
    }

    /**
     * Sets the password for the given user to the given password
     */
    public Map<String, Object> setUserPassword(SetUserPasswordRequest request) {
        PveResponse<Map<String, Object>> response = executor.post(this.basePath, request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}