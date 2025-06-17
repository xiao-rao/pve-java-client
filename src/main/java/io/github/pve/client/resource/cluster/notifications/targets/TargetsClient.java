package io.github.pve.client.resource.cluster.notifications.targets;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.cluster.notifications.targets.test.TestClient;
// Import models if needed
import io.github.pve.client.model.cluster.notifications.targets.*;

/**
 * Client for /cluster/notifications/targets
 * BY '@xiao-rao'
 */
public class TargetsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public TargetsClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/notifications/targets";
    }

    /**
     * Returns a list of all entities that can be used as notification targets.
     */
    public GetAllTargetsResponse getAllTargets() {
        PveResponse<GetAllTargetsResponse> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Client for the specific `name` resource.
     * @param name The path parameter `name`.
     */
    public TestClient test(String name) {
        return new TestClient(this.executor, name);
    }
}