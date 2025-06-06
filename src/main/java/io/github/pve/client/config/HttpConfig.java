package io.github.pve.client.config;

import lombok.Getter;

import java.time.Duration;

/**
 * HTTP客户端相关配置
 */
@Getter
public class HttpConfig {
    private final Duration connectTimeout;
    private final Duration readTimeout;
    private final Duration writeTimeout;
    private final int maxRetries; // 暂未在ProxmoxApiExecutor中完全实现，但可预留

    public HttpConfig() {
        this(Duration.ofSeconds(10), Duration.ofSeconds(30), Duration.ofSeconds(30), 0);
    }

    public HttpConfig(Duration connectTimeout, Duration readTimeout, Duration writeTimeout, int maxRetries) {
        this.connectTimeout = connectTimeout == null ? Duration.ofSeconds(10) : connectTimeout;
        this.readTimeout = readTimeout == null ? Duration.ofSeconds(30) : readTimeout;
        this.writeTimeout = writeTimeout == null ? Duration.ofSeconds(30) : writeTimeout;
        this.maxRetries = Math.max(0, maxRetries);
    }

}

