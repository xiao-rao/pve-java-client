package io.github.pve.client.resource.cluster.ceph;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.cluster.ceph.metadata.MetadataClient;
import io.github.pve.client.resource.cluster.ceph.status.StatusClient;
import io.github.pve.client.resource.cluster.ceph.flags.FlagsClient;

/**
 * Client for /cluster/ceph
 * BY '@xiao-rao'
 */
public class CephClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public CephClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/ceph";
    }

    /**
     * Cluster ceph index.
     */
    public List<Object> cephindex() {
        PveResponse<List<Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `metadata`
     */
    public MetadataClient metadata() {
        return new MetadataClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `status`
     */
    public StatusClient status() {
        return new StatusClient(this.executor);
    }

    /**
     * Returns a client for the sub-resource: `flags`
     */
    public FlagsClient flags() {
        return new FlagsClient(this.executor);
    }
}