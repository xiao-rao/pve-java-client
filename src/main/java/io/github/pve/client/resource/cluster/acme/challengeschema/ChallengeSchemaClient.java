package io.github.pve.client.resource.cluster.acme.challengeschema;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.cluster.acme.challengeschema.*;

/**
 * Client for /cluster/acme/challenge-schema
 * BY '@xiao-rao'
 */
public class ChallengeSchemaClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;

    public ChallengeSchemaClient(ProxmoxApiExecutor executor) {
        this.executor = executor;
        this.basePath = "/cluster/acme/challenge-schema";
    }

    /**
     * Get schema of ACME challenge types.
     */
    public ChallengeschemaResponse challengeschema() {
        PveResponse<ChallengeschemaResponse> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}