package io.github.pve.client.session;

import java.util.Optional;

/**
 * Proxmox会话缓存接口
 */
public interface ProxmoxSessionCache {
    Optional<ProxmoxSession> getSession(String nodeId);
    void putSession(ProxmoxSession session);
    void removeSession(String nodeId);
    void clearAllSessions();
}

