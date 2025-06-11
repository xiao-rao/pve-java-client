package io.github.pve.client.http;

import io.github.pve.client.config.ResilienceConfig;
import io.github.pve.client.exception.ProxmoxApiException;
import io.github.pve.client.exception.ProxmoxAuthException;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import lombok.Getter;

/**
 * 统一管理Resilience4j组件（断路器、重试、速率限制器）。
 */
@Getter
public class ResilienceManager {

    private final CircuitBreaker circuitBreaker;
    private final Retry retry;
    private final RateLimiter rateLimiter;

    public ResilienceManager(ResilienceConfig config) {
        this.circuitBreaker = createCircuitBreaker(config);
        this.retry = createRetry(config);
        this.rateLimiter = createRateLimiter(config);
    }

    private CircuitBreaker createCircuitBreaker(ResilienceConfig config) {
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .failureRateThreshold(config.getFailureRateThreshold())
                .slowCallRateThreshold(config.getSlowCallRateThreshold())
                .waitDurationInOpenState(config.getWaitDurationInOpenState())
                .slowCallDurationThreshold(config.getSlowCallDurationThreshold())
                .permittedNumberOfCallsInHalfOpenState(config.getPermittedNumberOfCallsInHalfOpenState())
                .minimumNumberOfCalls(config.getMinimumNumberOfCalls())
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                .slidingWindowSize(config.getMinimumNumberOfCalls())
                .ignoreExceptions(ProxmoxAuthException.class) // 不应将认证失败计为服务故障
                .build();
        CircuitBreakerRegistry registry = CircuitBreakerRegistry.of(circuitBreakerConfig);
        return registry.circuitBreaker("proxmox-api");
    }

    private Retry createRetry(ResilienceConfig config) {
        RetryConfig retryConfig = RetryConfig.custom()
                .maxAttempts(config.getMaxRetryAttempts())
                .waitDuration(config.getWaitDurationBetweenRetries())
                .retryOnException(e -> e instanceof ProxmoxApiException && ((ProxmoxApiException) e).getStatusCode() >= 500) // 仅对服务器端错误重试
                .build();
        RetryRegistry registry = RetryRegistry.of(retryConfig);
        return registry.retry("proxmox-api");
    }

    private RateLimiter createRateLimiter(ResilienceConfig config) {
        RateLimiterConfig rateLimiterConfig = RateLimiterConfig.custom()
                .limitRefreshPeriod(config.getRateLimitRefreshPeriod())
                .limitForPeriod(config.getRateLimitForPeriod())
                .timeoutDuration(config.getRateLimitTimeoutDuration())
                .build();
        RateLimiterRegistry registry = RateLimiterRegistry.of(rateLimiterConfig);
        return registry.rateLimiter("proxmox-api");
    }

}

