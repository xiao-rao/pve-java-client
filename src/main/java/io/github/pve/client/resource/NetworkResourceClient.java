package io.github.pve.client.resource;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.exception.ProxmoxApiException;
import io.github.pve.client.http.PveResponse;
import io.github.pve.client.model.network.NetworkDevice;
import io.github.pve.client.exception.ProxmoxAuthException;
import io.github.pve.client.http.ProxmoxApiExecutor;

import java.util.Collections;
import java.util.List;

/**
 * 网络资源客户端
 * 提供对Proxmox中节点网络配置的访问。
 */
public class NetworkResourceClient extends BaseResourceClient {

    public NetworkResourceClient(ProxmoxApiExecutor executor) {
        super(executor);
    }

    /**
     * 列出指定节点上的所有网络设备。
     * @param pveNodeName PVE集群内部的节点名
     * @return 网络设备列表
     * @throws ProxmoxApiException API调用失败
     * @throws ProxmoxAuthException 认证失败
     */
    public List<NetworkDevice> listNetworkDevices(String pveNodeName)   {
        String path = String.format("/nodes/%s/network", pveNodeName);
        PveResponse<List<NetworkDevice>> response = executor.get(path, null, new TypeReference<>() {});
        return response.getData().orElse(Collections.emptyList());
    }
}

