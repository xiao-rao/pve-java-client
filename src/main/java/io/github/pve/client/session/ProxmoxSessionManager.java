package io.github.pve.client.session;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.pve.client.auth.AuthenticationDetails;
import io.github.pve.client.auth.AuthenticationProvider;
import io.github.pve.client.config.CacheConfig;
import io.github.pve.client.exception.ProxmoxAuthException;
import io.github.pve.client.config.AuthenticationConfig;
import io.github.pve.client.config.NodeConnectionConfig;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Proxmox会话管理器
 * 负责获取、存储和刷新会话，处理并发获取会话的锁机制。
 */
public class ProxmoxSessionManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProxmoxSessionManager.class);

    private final ProxmoxSessionCache sessionCache;
    private final AuthenticationProvider authenticationProvider; // 用于在会话不存在或过期时重新认证
    private final CacheConfig cacheConfig; // 主要用于获取会话有效期
    private final Map<String, ReentrantLock> nodeLocks = new ConcurrentHashMap<>(); // 防止并发登录同一个节点

    public ProxmoxSessionManager(ProxmoxSessionCache sessionCache,
                                 AuthenticationProvider authenticationProvider,
                                 CacheConfig cacheConfig) {
        this.sessionCache = Objects.requireNonNull(sessionCache, "Session cache cannot be null");
        this.authenticationProvider = Objects.requireNonNull(authenticationProvider, "Authentication provider cannot be null");
        this.cacheConfig = Objects.requireNonNull(cacheConfig, "Cache config cannot be null");
    }

    /**
     * 获取指定节点的有效会话。
     * 如果会话不存在、已过期或需要CSRF刷新，则尝试创建或刷新会话。
     *
     * @param nodeConnectionConfig PVE节点连接配置
     * @param authConfig           认证方式配置
     * @param httpClient           用于执行HTTP请求的OkHttpClient实例
     * @param objectMapper         用于解析JSON的ObjectMapper实例
     * @return 有效的Proxmox会话
     * @throws ProxmoxAuthException 如果认证或会话刷新失败
     */
    public ProxmoxSession getValidSession(NodeConnectionConfig nodeConnectionConfig,
                                          AuthenticationConfig authConfig,
                                          OkHttpClient httpClient,
                                          ObjectMapper objectMapper) throws ProxmoxAuthException {
        String nodeId = nodeConnectionConfig.getNodeId();
        Optional<ProxmoxSession> cachedSessionOpt = sessionCache.getSession(nodeId);

        if (cachedSessionOpt.isPresent()) {
            ProxmoxSession session = cachedSessionOpt.get();
            // PVE的CSRF token通常与ticket（cookie）一起过期。
            // 如果我们设计了CSRF token的独立刷新逻辑（不通过重新登录），这里可以检查 session.needsCsrfRefresh()
            // 但通常，如果ticket快过期了，CSRF token也会一起重新获取。
            // 目前简单处理：只要会话有效就返回。未来可增加主动刷新CSRF token的逻辑。
            if (session.isValid()) {
                LOGGER.debug("Using existing valid session for node {}", nodeId);
                return session;
            } else {
                LOGGER.info("Session for node {} is invalid/expired. Attempting to re-authenticate.", nodeId);
            }
        } else {
            LOGGER.info("No session found for node {}. Attempting to authenticate.", nodeId);
        }

        // 获取节点锁，防止并发登录
        ReentrantLock lock = nodeLocks.computeIfAbsent(nodeId, k -> new ReentrantLock());
        lock.lock();
        try {
            // 双重检查锁定：在获取锁后再次检查缓存，因为其他线程可能已经创建了会话
            cachedSessionOpt = sessionCache.getSession(nodeId);
            if (cachedSessionOpt.isPresent() && cachedSessionOpt.get().isValid()) {
                LOGGER.debug("Session for node {} was created by another thread while waiting for lock.", nodeId);
                return cachedSessionOpt.get();
            }

            LOGGER.info("Authenticating to PVE node {} using {} method.",
                    nodeId, authConfig.getAuthType());

            AuthenticationDetails authDetails = authenticationProvider.authenticate(
                    nodeConnectionConfig, authConfig, httpClient, objectMapper
            );

            ProxmoxSession newSession = new ProxmoxSession(nodeId, authDetails, cacheConfig.getSessionDefaultValidity());
            sessionCache.putSession(newSession);
            LOGGER.info("Successfully created and cached new session for node {}", nodeId);
            return newSession;

        } finally {
            lock.unlock();
        }
    }

    /**
     * 使指定节点的会话无效（从缓存中移除）。
     * @param nodeId 节点ID
     */
    public void invalidateSession(String nodeId) {
        LOGGER.info("Invalidating session for node {}", nodeId);
        sessionCache.removeSession(nodeId);
    }

    /**
     * 清除所有缓存的会话。
     */
    public void clearAllSessions() {
        LOGGER.info("Clearing all cached PVE sessions.");
        sessionCache.clearAllSessions();
    }
}
