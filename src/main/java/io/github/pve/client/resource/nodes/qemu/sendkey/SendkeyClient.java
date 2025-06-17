package io.github.pve.client.resource.nodes.qemu.sendkey;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/qemu/{vmid}/sendkey
 * BY '@xiao-rao'
 */
public class SendkeyClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public SendkeyClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/qemu/{vmid}/sendkey".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * Send key event to virtual machine.
     */
    public void vmSendkey(String key, Boolean skiplock) {
        Map<String, Object> options = new HashMap<>();
        if (key != null) {
            options.put("key", key);
        }
        if (skiplock != null) {
            options.put("skiplock", skiplock);
        }
        executor.put(this.basePath, options);
    }
}