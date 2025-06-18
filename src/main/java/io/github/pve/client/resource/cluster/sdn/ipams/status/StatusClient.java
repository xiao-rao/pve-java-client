package io.github.pve.client.resource.cluster.sdn.ipams.status;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /cluster/sdn/ipams/{ipam}/status
 * BY '@xiao-rao'
 */
public class StatusClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String ipam;

    public StatusClient(ProxmoxApiExecutor executor, String ipam) {
        this.executor = executor;
        this.ipam = ipam;
        this.basePath = "/cluster/sdn/ipams/{ipam}/status".replace("{" + "ipam" + "}", ipam);
    }

    /**
     * List PVE IPAM Entries
     */
    public List<Object> ipamindex() {
        PveResponse<List<Object>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}