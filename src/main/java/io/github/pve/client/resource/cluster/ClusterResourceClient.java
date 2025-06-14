package io.github.pve.client.resource.cluster;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.resource.cluster.base.AcmeResourceClient;
import io.github.pve.client.util.Lazy;

/**
 * 集群 (Cluster) 模块的总入口 Facade.
 * 它将聚合所有 /cluster/* 路径下的子客户端。
 */
public class ClusterResourceClient {

    private final Lazy<AcmeResourceClient> acmeClient;
    // Future clients for /cluster/backup, /cluster/ha, etc. will be added here


    public ClusterResourceClient(ProxmoxApiExecutor executor) {
        this.acmeClient = new Lazy<>(() -> new AcmeResourceClient(executor));
        // ... instantiate other clients
    }

    /**
     * 获取 ACME (Let's Encrypt) 功能的客户端。
     */
    public AcmeResourceClient acme() {
        return acmeClient.get();
    }
}
