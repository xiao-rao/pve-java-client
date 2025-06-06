package io.github.pve.client.config;

import lombok.Getter;

import java.time.Duration;

/**
 * 缓存相关配置
 */
@Getter
public class CacheConfig {
    public enum CacheType {
        IN_MEMORY // 未来可扩展为 REDIS 等
    }

    private final CacheType sessionCacheType;
    private final Duration sessionDefaultValidity; // PVE Ticket typically 2 hours

    public CacheConfig() {
        this(CacheType.IN_MEMORY, Duration.ofHours(2));
    }

    public CacheConfig(CacheType sessionCacheType, Duration sessionDefaultValidity) {
        this.sessionCacheType = sessionCacheType == null ? CacheType.IN_MEMORY : sessionCacheType;
        this.sessionDefaultValidity = sessionDefaultValidity == null ? Duration.ofHours(2) : sessionDefaultValidity;
        if (this.sessionDefaultValidity.isNegative() || this.sessionDefaultValidity.isZero()) {
            throw new IllegalArgumentException("Session default validity must be positive.");
        }
    }

}
