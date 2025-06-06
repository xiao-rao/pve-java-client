package io.github.pve.client.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 基于内存的Proxmox会话缓存实现
 */
public class InMemoryProxmoxSessionCache implements ProxmoxSessionCache {
    private static final Logger LOGGER = LoggerFactory.getLogger(InMemoryProxmoxSessionCache.class);
    private final Map<String, ProxmoxSession> cache = new ConcurrentHashMap<>();

    @Override
    public Optional<ProxmoxSession> getSession(String nodeId) {
        ProxmoxSession session = cache.get(nodeId);
        if (session != null) {
            if (session.isValid()) {
                LOGGER.trace("Found valid session in cache for node {}", nodeId);
                return Optional.of(session);
            } else {
                LOGGER.info("Found expired session in cache for node {}. Removing.", nodeId);
                cache.remove(nodeId); // Eagerly remove expired session
                return Optional.empty();
            }
        }
        LOGGER.trace("No session found in cache for node {}", nodeId);
        return Optional.empty();
    }

    @Override
    public void putSession(ProxmoxSession session) {
        if (session == null || session.getNodeId() == null) {
            LOGGER.warn("Attempted to cache a null session or session with null nodeId.");
            return;
        }
        LOGGER.debug("Caching session for node {}. Expires at: {}", session.getNodeId(), session.getExpiryTime());
        cache.put(session.getNodeId(), session);
    }

    @Override
    public void removeSession(String nodeId) {
        LOGGER.debug("Removing session from cache for node {}", nodeId);
        cache.remove(nodeId);
    }

    @Override
    public void clearAllSessions() {
        LOGGER.info("Clearing all sessions from InMemoryProxmoxSessionCache.");
        cache.clear();
    }
}
