package io.github.pve.client.resource.cluster.notifications.targets.test;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /cluster/notifications/targets/{name}/test
 * BY '@xiao-rao'
 */
public class TestClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String name;

    public TestClient(ProxmoxApiExecutor executor, String name) {
        this.executor = executor;
        this.name = name;
        this.basePath = "/cluster/notifications/targets/{name}/test".replace("{name}", name);
    }

    /**
     * Send a test notification to a provided target.
     */
    public void testTarget() {
        executor.post(this.basePath);
    }
}