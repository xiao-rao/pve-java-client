package io.github.pve.client;

import io.github.pve.client.config.ProxmoxClientConfig;

/**
 * Proxmox API客户端工厂.
 * 用于构建可关闭的 ProxmoxApiClient 实例。
 */
public class ProxmoxApiClientFactory {

    /**
     * 使用给定的配置创建一个新的ProxmoxApiClient实例。
     *
     * @param config Proxmox客户端配置
     * @return 一个新的、可关闭的ProxmoxApiClient实例
     */
    public static ProxmoxApiClient createClient(ProxmoxClientConfig config) {
        return new ProxmoxApiClient(config);
    }
}
