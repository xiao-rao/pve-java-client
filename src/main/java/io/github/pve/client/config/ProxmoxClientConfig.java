package io.github.pve.client.config;

import lombok.Getter;

import java.util.Objects;

/**
 * Proxmox API客户端的整体配置
 * 聚合了连接、认证、HTTP和缓存配置
 */
@Getter
public class ProxmoxClientConfig {

    private final NodeConnectionConfig nodeConnectionConfig;
    private final AuthenticationConfig authenticationConfig;
    private final HttpConfig httpConfig;
    private final CacheConfig cacheConfig;
    private final ResilienceConfig resilienceConfig; // 新增韧性配置


    public ProxmoxClientConfig(NodeConnectionConfig nodeConnectionConfig,
                               AuthenticationConfig authenticationConfig,
                               HttpConfig httpConfig,
                               CacheConfig cacheConfig,
                               ResilienceConfig resilienceConfig) {
        this.nodeConnectionConfig = Objects.requireNonNull(nodeConnectionConfig, "NodeConnectionConfig cannot be null");
        this.authenticationConfig = Objects.requireNonNull(authenticationConfig, "AuthenticationConfig cannot be null");
        this.httpConfig = httpConfig == null ? new HttpConfig() : httpConfig;
        this.cacheConfig = cacheConfig == null ? new CacheConfig() : cacheConfig;
        this.resilienceConfig = resilienceConfig == null ? ResilienceConfig.defaults() : resilienceConfig;
    }

    // Builder Pattern for easier construction
    public static Builder builder(String nodeId, String apiUrl, AuthenticationConfig authConfig) {
        return new Builder(nodeId, apiUrl, authConfig);
    }

    public static class Builder {
        private final String nodeId;
        private final String apiUrl;
        private final AuthenticationConfig authenticationConfig;
        private boolean trustSelfSignedCerts = false;
        private HttpConfig httpConfig = new HttpConfig();
        private CacheConfig cacheConfig = new CacheConfig();
        private ResilienceConfig resilienceConfig = ResilienceConfig.defaults();


        public Builder(String nodeId, String apiUrl, AuthenticationConfig authenticationConfig) {
            this.nodeId = nodeId;
            this.apiUrl = apiUrl;
            this.authenticationConfig = authenticationConfig;
        }

        public Builder trustSelfSignedCerts(boolean trust) {
            this.trustSelfSignedCerts = trust;
            return this;
        }

        public Builder resilienceConfig(ResilienceConfig resilienceConfig) {
            this.resilienceConfig = resilienceConfig;
            return this;
        }

        public Builder httpConfig(HttpConfig httpConfig) {
            this.httpConfig = httpConfig;
            return this;
        }

        public Builder cacheConfig(CacheConfig cacheConfig) {
            this.cacheConfig = cacheConfig;
            return this;
        }


        public ProxmoxClientConfig build() {
            NodeConnectionConfig nodeConnConfig = new NodeConnectionConfig(nodeId, apiUrl, trustSelfSignedCerts);
            return new ProxmoxClientConfig(nodeConnConfig, authenticationConfig, httpConfig, cacheConfig,resilienceConfig);
        }
    }
}
