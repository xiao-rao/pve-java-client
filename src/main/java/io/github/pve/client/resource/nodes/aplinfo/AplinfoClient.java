package io.github.pve.client.resource.nodes.aplinfo;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/aplinfo
 * BY '@xiao-rao'
 */
public class AplinfoClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public AplinfoClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/aplinfo".replace("{" + "node" + "}", node);
    }

    /**
     * Get list of appliances.
     */
    public List<Object> aplinfo() {
        PveResponse<List<Object>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Download appliance templates.
     */
    public String aplDownload(String storage, String template) {
        String path = this.basePath + "/" + storage;
        Map<String, Object> options = new HashMap<>();
        if (template != null) {
            options.put("template", template);
        }
        PveResponse<String> response = executor.post(path, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}