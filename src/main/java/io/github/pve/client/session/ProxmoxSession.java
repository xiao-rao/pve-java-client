package io.github.pve.client.session;


import io.github.pve.client.auth.AuthenticationDetails;
import lombok.Getter;

import java.time.Duration;
import java.time.Instant;

/**
 * Proxmox会话信息
 */
@Getter
public class ProxmoxSession {
    private final String nodeId;
    private final AuthenticationDetails authDetails;
    private final Instant expiryTime; // 会话过期时间
    private final Instant csrfRefreshTime; // CSRF Token 建议刷新时间 (略早于过期时间)

    public ProxmoxSession(String nodeId, AuthenticationDetails authDetails, Duration validityDuration) {
        this.nodeId = nodeId;
        this.authDetails = authDetails;
        this.expiryTime = Instant.now().plus(validityDuration);
        // Refresh CSRF token a bit earlier, e.g., 90% of validity or 5 mins before expiry
        long refreshOffsetSeconds = Math.max(60, validityDuration.getSeconds() / 10); // e.g. 10% or at least 1 min
        this.csrfRefreshTime = expiryTime.minusSeconds(refreshOffsetSeconds);
    }


    public String getTicket() {
        return authDetails.getTicket();
    }

    public String getCsrfToken() {
        return authDetails.getCsrfToken();
    }

    public String getUsername() {
        return authDetails.getUsername();
    }


    public boolean isValid() {
        return Instant.now().isBefore(expiryTime);
    }

    public boolean needsCsrfRefresh() {
        return Instant.now().isAfter(csrfRefreshTime) && isValid(); // Needs refresh but not yet fully expired
    }

    @Override
    public String toString() {
        return "ProxmoxSession{" +
                "nodeId='" + nodeId + '\'' +
                ", username='" + getUsername() + '\'' +
                ", expiryTime=" + expiryTime +
                ", isValid=" + isValid() +
                '}';
    }
}

