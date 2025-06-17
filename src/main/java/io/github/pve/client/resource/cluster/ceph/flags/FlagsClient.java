package io.github.pve.client.resource.cluster.ceph.flags;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.ceph.flags.*;

/**
 * Client for /cluster/ceph/flags
 * BY '@xiao-rao'
 */
public class FlagsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public FlagsClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/ceph/flags";
    }

    /**
     * get the status of all ceph flags
     */
    public List<Object> getAllFlags() {
        PveResponse<List<Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Set/Unset multiple ceph flags at once.
     */
    public String setFlags(SetFlagsRequest request) {
        PveResponse<String> response = executor.put(this.basePath, request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Get the status of a specific ceph flag.
     */
    public void getFlag(String flag) {
        executor.get(this.basePath + "/" + flag);
    }

    /**
     * Set or clear (unset) a specific ceph flag
     */
    public void updateFlag(String flag, Boolean value) {
        String path = this.basePath + "/" + flag;
        Map<String, Object> options = new HashMap<>();
        if (value != null) {
            options.put("value", value);
        }
        executor.put(path, options);
    }
}