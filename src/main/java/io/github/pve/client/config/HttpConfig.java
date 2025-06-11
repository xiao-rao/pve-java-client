package io.github.pve.client.config;

import lombok.Getter;

import java.time.Duration;


/**
 * HTTP客户端相关配置, 包含连接池设置。
 */
@Getter
public class HttpConfig {
    private final Duration connectTimeout;
    private final Duration readTimeout;
    private final Duration writeTimeout;

    // --- 新增连接池配置 ---
    private final int maxIdleConnections;
    private final Duration keepAliveDuration;

    /**
     * 使用默认配置创建HttpConfig。
     * 默认: connectTimeout=10s, readTimeout=30s, writeTimeout=30s,
     * maxIdleConnections=5, keepAliveDuration=5min
     */
    public HttpConfig() {
        this(Duration.ofSeconds(10), Duration.ofSeconds(30), Duration.ofSeconds(30), 5, Duration.ofMinutes(5));
    }

    /**
     * 创建自定义的HttpConfig。
     * @param connectTimeout 连接超时
     * @param readTimeout 读取超时
     * @param writeTimeout 写入超时
     * @param maxIdleConnections 最大空闲连接数
     * @param keepAliveDuration 空闲连接保持时长
     */
    public HttpConfig(Duration connectTimeout, Duration readTimeout, Duration writeTimeout, int maxIdleConnections, Duration keepAliveDuration) {
        this.connectTimeout = connectTimeout == null ? Duration.ofSeconds(10) : connectTimeout;
        this.readTimeout = readTimeout == null ? Duration.ofSeconds(30) : readTimeout;
        this.writeTimeout = writeTimeout == null ? Duration.ofSeconds(30) : writeTimeout;
        this.maxIdleConnections = Math.max(0, maxIdleConnections);
        this.keepAliveDuration = keepAliveDuration == null ? Duration.ofMinutes(5) : keepAliveDuration;
    }

}

