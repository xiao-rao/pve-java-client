package io.github.pve.client.resource;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.exception.ProxmoxApiException;
import io.github.pve.client.exception.ProxmoxAuthException;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import io.github.pve.client.model.cluster.ClusterResource;
import io.github.pve.client.model.cluster.ClusterStatus;

import java.util.Collections;
import java.util.List;

/**
 * 集群资源客户端.
 */
public class ClusterResourceClient extends BaseResourceClient {

    public ClusterResourceClient(ProxmoxApiExecutor executor) {
        super(executor);
    }

    /**
     * 获取集群状态。
     */
    public List<ClusterStatus> getStatus()   {
        PveResponse<List<ClusterStatus>> response = executor.get("/cluster/status", null, new TypeReference<>() {});
        return response.getData().orElse(Collections.emptyList());
    }

    /**
     * 获取集群中的所有资源。
     */
    public List<ClusterResource> getResources()   {
        PveResponse<List<ClusterResource>> response = executor.get("/cluster/resources", null, new TypeReference<>() {});
        return response.getData().orElse(Collections.emptyList());
    }

    /**
     * 获取集群中下一个可用的VMID。
     */
    public Integer getNextVmId()   {
        PveResponse<String> response = executor.get("/cluster/nextid", null, new TypeReference<>() {});
        String nextIdStr = response.getData().orElseThrow(() -> new ProxmoxApiException("Next VMID not returned", response.getStatusCode(), null, null, "/cluster/nextid"));
        return Integer.parseInt(nextIdStr);
    }
}

