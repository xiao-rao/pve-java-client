package io.github.pve.client;


import io.github.pve.client.config.ProxmoxClientConfig;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.auth.ApiTokenAuthProvider;
import io.github.pve.client.auth.AuthenticationProvider;
import io.github.pve.client.auth.UsernamePasswordAuthProvider;
import io.github.pve.client.config.AuthenticationConfig;
import io.github.pve.client.http.ResilienceManager;
import io.github.pve.client.resource.access.AccessResourceClient;
import io.github.pve.client.resource.cluster.ClusterResourceClient;
import io.github.pve.client.resource.pools.PoolResourceClient;
import io.github.pve.client.resource.storage.StorageResourceClient;
import io.github.pve.client.resource.version.VersionResourceClient;
import io.github.pve.client.session.InMemoryProxmoxSessionCache;
import io.github.pve.client.session.ProxmoxSessionManager;
import io.github.pve.client.util.Lazy;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.Closeable;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;


/**
 * Proxmox API客户端，聚合了对不同资源的访问。
 * 此类实现了 Closeable 接口，必须在使用完毕后调用 close() 方法以释放HTTP连接资源。
 * 推荐使用 try-with-resources 语法来自动管理其生命周期。
 */
public class ProxmoxApiClient implements Closeable {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProxmoxApiClient.class);

    private final OkHttpClient httpClient; // 客户端持有的唯一OkHttpClient实例
    private final ProxmoxApiExecutor apiExecutor;

    // Resource-specific clients
    private final Lazy<AccessResourceClient> accessClient;
    private final Lazy<ClusterResourceClient> clusterClient;
    private final Lazy<PoolResourceClient> poolClient;
    private final Lazy<StorageResourceClient> storageClient;
    private final Lazy<VersionResourceClient> versionClient;
    // ... 其他客户端字段

    ProxmoxApiClient(ProxmoxClientConfig config) {
        // --- 1. 创建和配置唯一的OkHttpClient实例 ---
        ConnectionPool connectionPool = new ConnectionPool(
                config.getHttpConfig().getMaxIdleConnections(),
                config.getHttpConfig().getKeepAliveDuration().toMillis(),
                TimeUnit.MILLISECONDS
        );

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectionPool(connectionPool)
                .connectTimeout(config.getHttpConfig().getConnectTimeout())
                .readTimeout(config.getHttpConfig().getReadTimeout())
                .writeTimeout(config.getHttpConfig().getWriteTimeout());

        if (config.getNodeConnectionConfig().isTrustSelfSignedCerts()) {
            configureToTrustSelfSignedCerts(builder, config.getNodeConnectionConfig().getNodeId());
        }
        this.httpClient = builder.build();

        // --- 2. 设置认证和会话管理 ---
        AuthenticationProvider authProvider = config.getAuthenticationConfig().getAuthType() == AuthenticationConfig.AuthType.API_TOKEN
                ? new ApiTokenAuthProvider() : new UsernamePasswordAuthProvider();
        InMemoryProxmoxSessionCache sessionCache = new InMemoryProxmoxSessionCache();
        ProxmoxSessionManager sessionManager = new ProxmoxSessionManager(sessionCache, authProvider, config.getCacheConfig());
        ResilienceManager resilienceManager = new ResilienceManager(config.getResilienceConfig());

        // --- 3. 创建API执行器，并传入已配置好的httpClient ---
         this.apiExecutor = new ProxmoxApiExecutor(config, sessionManager, this.httpClient, resilienceManager);

        this.accessClient = new Lazy<>(() -> new AccessResourceClient(this.apiExecutor));
        this.clusterClient = new Lazy<>(() -> new ClusterResourceClient(this.apiExecutor));
        this.poolClient = new Lazy<>(() -> new PoolResourceClient(this.apiExecutor));
        this.storageClient = new Lazy<>(() -> new StorageResourceClient(this.apiExecutor));
        this.versionClient = new Lazy<>(() -> new VersionResourceClient(this.apiExecutor));
        LOGGER.info("ProxmoxApiClient initialized for node '{}' with API URL '{}'.",
                config.getNodeConnectionConfig().getNodeId(),
                config.getNodeConnectionConfig().getApiUrl());
    }

    // --- Public accessors for resource clients ---
    public AccessResourceClient access() {
        return accessClient.get();
    }

    public ClusterResourceClient cluster() {
        return clusterClient.get();
    }

    public PoolResourceClient pools() {
        return poolClient.get();
    }

    public StorageResourceClient storage() {
        return storageClient.get();
    }

    public VersionResourceClient version() {
        return versionClient.get();
    }

    /**
     * 关闭客户端并释放所有HTTP连接资源。
     * 调用此方法后，客户端实例将不可再用。
     */
    @Override
    public void close() {
        LOGGER.info("Closing ProxmoxApiClient and shutting down HTTP client resources...");
        if (this.httpClient != null) {
            this.httpClient.dispatcher().executorService().shutdown();
            this.httpClient.connectionPool().evictAll();
        }
        LOGGER.info("ProxmoxApiClient closed.");
    }

    // --- Helper method for SSL ---
    private void configureToTrustSelfSignedCerts(OkHttpClient.Builder builder, String nodeId) {
        try {
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[]{};
                        }
                    }
            };
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier((hostname, session) -> true);
            LOGGER.warn("OkHttpClient for node '{}' is configured to trust self-signed certificates. THIS IS INSECURE AND SHOULD ONLY BE USED IN DEVELOPMENT/TESTING ENVIRONMENTS.", nodeId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to configure SSL for self-signed certificates", e);
        }
    }
}

