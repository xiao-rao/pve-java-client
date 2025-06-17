package io.github.pve.client.resource.nodes.certificates.acme.certificate;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/certificates/acme/certificate
 * BY '@xiao-rao'
 */
public class CertificateClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public CertificateClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/certificates/acme/certificate".replace("{" + "node" + "}", node);
    }

    /**
     * Revoke existing certificate from CA.
     */
    public String revokeCertificate() {
        PveResponse<String> response = executor.delete(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Order a new certificate from ACME-compatible CA.
     */
    public String newCertificate(Boolean force) {
        Map<String, Object> options = new HashMap<>();
        if (force != null) {
            options.put("force", force);
        }
        PveResponse<String> response = executor.post(this.basePath, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Renew existing certificate from CA.
     */
    public String renewCertificate(Boolean force) {
        Map<String, Object> options = new HashMap<>();
        if (force != null) {
            options.put("force", force);
        }
        PveResponse<String> response = executor.put(this.basePath, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}