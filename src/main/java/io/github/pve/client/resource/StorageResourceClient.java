package io.github.pve.client.resource;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.exception.ProxmoxApiException;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import io.github.pve.client.exception.ProxmoxAuthException;
import io.github.pve.client.model.storage.StorageContentItem;
import io.github.pve.client.model.storage.StorageSummary;

import java.util.Collections;
import java.util.List;

/**
 * 存储资源客户端
 * 提供对Proxmox中存储及内容的访问。
 */
public class StorageResourceClient extends BaseResourceClient {

    public StorageResourceClient(ProxmoxApiExecutor executor) {
        super(executor);
    }

    /**
     * 列出指定节点可见的所有存储。
     * @param pveNodeName PVE集群内部的节点名
     * @return 存储摘要列表
     * @throws ProxmoxApiException API调用失败
     * @throws ProxmoxAuthException 认证失败
     */
    public List<StorageSummary> listStorages(String pveNodeName) throws ProxmoxApiException, ProxmoxAuthException {
        String path = String.format("/nodes/%s/storage", pveNodeName);
        PveResponse<List<StorageSummary>> response = executor.get(path, null, new TypeReference<>() {});
        return response.getData().orElse(Collections.emptyList());
    }

    /**
     * 列出指定存储中的所有内容。
     * @param pveNodeName PVE节点名
     * @param storageId 存储ID
     * @return 存储内容项列表
     * @throws ProxmoxApiException API调用失败
     * @throws ProxmoxAuthException 认证失败
     */
    public List<StorageContentItem> listStorageContent(String pveNodeName, String storageId) throws ProxmoxApiException, ProxmoxAuthException {
        String path = String.format("/nodes/%s/storage/%s/content", pveNodeName, storageId);
        PveResponse<List<StorageContentItem>> response = executor.get(path, null, new TypeReference<>() {});
        return response.getData().orElse(Collections.emptyList());
    }
}
