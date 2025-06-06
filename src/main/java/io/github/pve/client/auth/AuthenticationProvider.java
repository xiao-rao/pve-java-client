package io.github.pve.client.auth;

import com.fasterxml.jackson.databind.ObjectMapper; // For implementations
import io.github.pve.client.config.AuthenticationConfig;
import io.github.pve.client.config.NodeConnectionConfig;
import io.github.pve.client.exception.ProxmoxAuthException;
import okhttp3.OkHttpClient;

/**
 * 认证提供者接口
 * 负责根据配置执行认证操作（例如，登录）并返回认证详情。
 */
public interface AuthenticationProvider {
    /**
     * 执行认证操作。
     *
     * @param nodeConnectionConfig PVE节点连接配置
     * @param authConfig           认证方式配置
     * @param httpClient           用于执行HTTP请求的OkHttpClient实例
     * @param objectMapper         用于解析JSON的ObjectMapper实例
     * @return 认证成功后的凭据详情
     * @throws ProxmoxAuthException 如果认证失败
     */
    AuthenticationDetails authenticate(NodeConnectionConfig nodeConnectionConfig,
                                       AuthenticationConfig authConfig,
                                       OkHttpClient httpClient,
                                       ObjectMapper objectMapper) throws ProxmoxAuthException;
}

