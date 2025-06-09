package io.github.pve.client.resource;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.exception.ProxmoxApiException;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import io.github.pve.client.exception.ProxmoxAuthException;
import io.github.pve.client.model.node.NodeStatus;
import io.github.pve.client.model.vm.VirtualMachineSummary;

import java.util.Collections;
import java.util.List;

/**
 * 节点资源客户端
 */
public class NodeResourceClient extends BaseResourceClient {
    public NodeResourceClient(ProxmoxApiExecutor executor) {
        super(executor);
    }

    /**
     * 获取指定PVE节点的状态。
     * @param pveNodeName PVE集群内部的节点名
     * @return 节点状态
     * @throws ProxmoxApiException API调用失败
     * @throws ProxmoxAuthException 认证失败
     */
    public NodeStatus getNodeStatus(String pveNodeName)   {
        String path = String.format("/nodes/%s/status", pveNodeName);
        PveResponse<NodeStatus> response = executor.get(path, null, new TypeReference<NodeStatus>() {});
        return response.getData().orElseThrow(() -> new ProxmoxApiException("Node status data is null", response.getStatusCode(), null, pveNodeName, path));
    }

    /**
     * 列出指定PVE节点上的所有虚拟机。
     * @param pveNodeName PVE集群内部的节点名
     * @return VM概要列表
     * @throws ProxmoxApiException API调用失败
     * @throws ProxmoxAuthException 认证失败
     */
    public List<VirtualMachineSummary> listVirtualMachines(String pveNodeName)   {
        String path = String.format("/nodes/%s/qemu", pveNodeName);
        PveResponse<List<VirtualMachineSummary>> response = executor.get(path, null, new TypeReference<List<VirtualMachineSummary>>() {});
        return response.getData().orElse(Collections.emptyList());
    }

    // ... 其他与节点相关的API方法，例如列出存储、网络等 ...
}
