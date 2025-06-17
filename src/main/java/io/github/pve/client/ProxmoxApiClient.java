package io.github.pve.client;

import io.github.pve.client.auth.ApiTokenAuthProvider;
import io.github.pve.client.auth.AuthenticationProvider;
import io.github.pve.client.auth.UsernamePasswordAuthProvider;
import io.github.pve.client.config.AuthenticationConfig;
import io.github.pve.client.config.ProxmoxClientConfig;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.ResilienceManager;
import io.github.pve.client.session.InMemoryProxmoxSessionCache;
import io.github.pve.client.session.ProxmoxSessionManager;
import io.github.pve.client.util.Lazy;
import io.github.pve.client.resource.cluster.ClusterClient;
import io.github.pve.client.resource.nodes.NodesClient;
import io.github.pve.client.resource.storage.StorageClient;
import io.github.pve.client.resource.access.AccessClient;
import io.github.pve.client.resource.pools.PoolsClient;
import io.github.pve.client.resource.version.VersionClient;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

/**
 *
 * BY '@xiao-rao'
 */
public class ProxmoxApiClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProxmoxApiClient.class);
    private final OkHttpClient httpClient; // 客户端持有的唯一OkHttpClient实例

    private final ProxmoxApiExecutor executor;

    private final Lazy<ClusterClient> clusterClient;
    private final Lazy<NodesClient> nodesClient;
    private final Lazy<StorageClient> storageClient;
    private final Lazy<AccessClient> accessClient;
    private final Lazy<PoolsClient> poolsClient;
    private final Lazy<VersionClient> versionClient;

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
        this.executor = new ProxmoxApiExecutor(config, sessionManager, this.httpClient, resilienceManager);
        this.clusterClient = new Lazy<>(() -> new ClusterClient(this.executor));
        this.nodesClient = new Lazy<>(() -> new NodesClient(this.executor));
        this.storageClient = new Lazy<>(() -> new StorageClient(this.executor));
        this.accessClient = new Lazy<>(() -> new AccessClient(this.executor));
        this.poolsClient = new Lazy<>(() -> new PoolsClient(this.executor));
        this.versionClient = new Lazy<>(() -> new VersionClient(this.executor));
        LOGGER.info("ProxmoxApiClient initialized for node '{}' with API URL '{}'.",
                config.getNodeConnectionConfig().getNodeId(),
                config.getNodeConnectionConfig().getApiUrl());
    }

    /**
     * Client for all operations related to cluster.
     */
    public ClusterClient cluster() {
        return this.clusterClient.get();
    }
    /**
     * Client for all operations related to nodes.
     */
    public NodesClient nodes() {
        return this.nodesClient.get();
    }
    /**
     * Client for all operations related to storage.
     */
    public StorageClient storage() {
        return this.storageClient.get();
    }
    /**
     * Client for all operations related to access.
     */
    public AccessClient access() {
        return this.accessClient.get();
    }
    /**
     * Client for all operations related to pools.
     */
    public PoolsClient pools() {
        return this.poolsClient.get();
    }
    /**
     * Client for all operations related to version.
     */
    public VersionClient version() {
        return this.versionClient.get();
    }


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