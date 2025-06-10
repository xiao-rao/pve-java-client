package io.github.pve.client;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.config.ProxmoxClientConfig;
import io.github.pve.client.exception.ProxmoxApiException;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.auth.ApiTokenAuthProvider;
import io.github.pve.client.auth.AuthenticationProvider;
import io.github.pve.client.auth.UsernamePasswordAuthProvider;
import io.github.pve.client.config.AuthenticationConfig;
import io.github.pve.client.exception.ProxmoxAuthException;
import io.github.pve.client.resource.access.AccessResourceClient;
import io.github.pve.client.resource.cluster.ClusterResourceClient;
import io.github.pve.client.resource.pools.PoolResourceClient;
import io.github.pve.client.resource.storage.StorageResourceClient;
import io.github.pve.client.resource.version.VersionResourceClient;
import io.github.pve.client.session.InMemoryProxmoxSessionCache;
import io.github.pve.client.session.ProxmoxSessionManager;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Proxmox API客户端，聚合了对不同资源的访问。
 */
public class ProxmoxApiClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProxmoxApiClient.class);


    private final ProxmoxApiExecutor apiExecutor;
    private final AccessResourceClient accessClient;
    private final ClusterResourceClient clusterClient;
    private final PoolResourceClient poolClient;
    private final StorageResourceClient storageClient;
    private final VersionResourceClient versionClient;

    ProxmoxApiClient(ProxmoxClientConfig config, OkHttpClient sharedOkHttpClientTemplate) {
        AuthenticationProvider authProvider = config.getAuthenticationConfig().getAuthType() == AuthenticationConfig.AuthType.API_TOKEN
                ? new ApiTokenAuthProvider() : new UsernamePasswordAuthProvider();
        InMemoryProxmoxSessionCache sessionCache = new InMemoryProxmoxSessionCache();
        ProxmoxSessionManager sessionManager = new ProxmoxSessionManager(sessionCache, authProvider, config.getCacheConfig());
        this.apiExecutor = new ProxmoxApiExecutor(config, sessionManager, sharedOkHttpClientTemplate);

        // Initialize all resource clients
        this.accessClient = new AccessResourceClient(this.apiExecutor);
        this.clusterClient = new ClusterResourceClient(this.apiExecutor);
        this.poolClient = new PoolResourceClient(this.apiExecutor);
        this.storageClient = new StorageResourceClient(this.apiExecutor);
        this.versionClient = new VersionResourceClient(this.apiExecutor);
        // ...
    }

    public AccessResourceClient access() {
        return accessClient;
    }

    public ClusterResourceClient cluster() {
        return clusterClient;
    }

    public PoolResourceClient pools() {
        return poolClient;
    }

    public StorageResourceClient storage() {
        return storageClient;
    }

    public VersionResourceClient version() {
        return versionClient;
    }

    public void connect() throws ProxmoxAuthException {
        LOGGER.debug("Explicitly connecting/pre-warming session...");
        try {
            this.apiExecutor.get("/version", null, new TypeReference<>() {
            });
            LOGGER.info("Successfully connected and pre-warmed session.");
        } catch (ProxmoxApiException e) {
            LOGGER.warn("Pre-warming session encountered an API issue: {}", e.getMessage());
        }
    }
}

