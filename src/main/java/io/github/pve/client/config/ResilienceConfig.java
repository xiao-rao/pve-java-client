package io.github.pve.client.config;

import lombok.Builder;
import lombok.Value;

import java.time.Duration;

/**
 * 客户端韧性模式 (Resilience Patterns) 配置.
 * 提供了对断路器、重试和速率限制器的详细配置。
 */
@Value
@Builder(toBuilder = true)
public class ResilienceConfig {

    // --- Circuit Breaker Settings ---
    @Builder.Default
    float failureRateThreshold = 50.0f;
    @Builder.Default
    Duration slowCallDurationThreshold = Duration.ofSeconds(60);
    @Builder.Default
    float slowCallRateThreshold = 100.0f;
    @Builder.Default
    int permittedNumberOfCallsInHalfOpenState = 10;
    @Builder.Default
    int minimumNumberOfCalls = 100;
    @Builder.Default
    Duration waitDurationInOpenState = Duration.ofSeconds(60);

    // --- Retry Settings ---
    @Builder.Default
    int maxRetryAttempts = 3;
    @Builder.Default
    Duration waitDurationBetweenRetries = Duration.ofMillis(500);

    // --- Rate Limiter Settings ---
    @Builder.Default
    int rateLimitForPeriod = 50;
    @Builder.Default
    Duration rateLimitRefreshPeriod = Duration.ofSeconds(1);
    @Builder.Default
    Duration rateLimitTimeoutDuration = Duration.ofSeconds(5);

    /**
     * 创建一个包含默认值的实例。
     */
    public static ResilienceConfig defaults() {
        return ResilienceConfig.builder().build();
    }
}

