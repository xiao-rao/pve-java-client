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
import io.github.pve.client.resource.*;
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

    private final ClusterResourceClient clusterClient;
    private final NodeResourceClient nodeClient;
    private final VirtualMachineResourceClient vmClient;
    private final StorageResourceClient storageClient;
    private final NetworkResourceClient networkClient;
    private final AccessResourceClient accessClient;
    private final PoolResourceClient poolClient;

    ProxmoxApiClient(ProxmoxClientConfig config, OkHttpClient sharedOkHttpClientTemplate) {
        AuthenticationProvider authProvider = config.authenticationConfig().getAuthType() == AuthenticationConfig.AuthType.API_TOKEN ?
                new ApiTokenAuthProvider() : new UsernamePasswordAuthProvider();

        InMemoryProxmoxSessionCache sessionCache = new InMemoryProxmoxSessionCache();
        ProxmoxSessionManager sessionManager = new ProxmoxSessionManager(sessionCache, authProvider, config.cacheConfig());

        this.apiExecutor = new ProxmoxApiExecutor(config, sessionManager, sharedOkHttpClientTemplate);

        this.clusterClient = new ClusterResourceClient(this.apiExecutor);
        this.nodeClient = new NodeResourceClient(this.apiExecutor);
        this.vmClient = new VirtualMachineResourceClient(this.apiExecutor);
        this.storageClient = new StorageResourceClient(this.apiExecutor);
        this.networkClient = new NetworkResourceClient(this.apiExecutor);
        this.accessClient = new AccessResourceClient(this.apiExecutor);
        this.poolClient = new PoolResourceClient(this.apiExecutor);

        LOGGER.info("ProxmoxApiClient initialized for node '{}' with API URL '{}' and auth type '{}'.",
                config.nodeConnectionConfig().nodeId(), config.nodeConnectionConfig().apiUrl(),
                config.authenticationConfig().getAuthType());
    }

    public ClusterResourceClient cluster() { return clusterClient; }
    public NodeResourceClient nodes() { return nodeClient; }
    public VirtualMachineResourceClient virtualMachines() { return vmClient; }
    public StorageResourceClient storage() { return storageClient; }
    public NetworkResourceClient network() { return networkClient; }
    public AccessResourceClient access() { return accessClient; }
    public PoolResourceClient pools() { return poolClient; }

    public void connect() throws ProxmoxAuthException {
        LOGGER.debug("Explicitly connecting/pre-warming session...");
        try {
            this.apiExecutor.get("/version", null, new TypeReference<>() {});
            LOGGER.info("Successfully connected and pre-warmed session.");
        } catch (ProxmoxApiException e) {
            LOGGER.warn("Pre-warming session encountered an API issue: {}", e.getMessage());
        }
    }
}

