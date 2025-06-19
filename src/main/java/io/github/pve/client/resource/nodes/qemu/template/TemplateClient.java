package io.github.pve.client.resource.nodes.qemu.template;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/qemu/{vmid}/template
 * BY '@xiao-rao'
 */
public class TemplateClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmId;

    public TemplateClient(ProxmoxApiExecutor executor, String node, String vmId) {
        this.executor = executor;
        this.node = node;
        this.vmId = vmId;
        this.basePath = "/nodes/{node}/qemu/{vmid}/template".replace("{node}", node).replace("{vmid}", vmId);
    }

    /**
     * Create a Template.
     */
    public String template(String disk) {
        Map<String, Object> options = new HashMap<>();
        if (disk != null) {
            options.put("disk", disk);
        }
        PveResponse<String> response = executor.post(this.basePath, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}