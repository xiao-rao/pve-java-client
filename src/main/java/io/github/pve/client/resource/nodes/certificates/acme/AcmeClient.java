package io.github.pve.client.resource.nodes.certificates.acme;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.certificates.acme.certificate.CertificateClient;

/**
 * Client for /nodes/{node}/certificates/acme
 * BY '@xiao-rao'
 */
public class AcmeClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public AcmeClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/certificates/acme".replace("{node}", node);
    }

    /**
     * ACME index.
     */
    public List<Object> index() {
        PveResponse<List<Object>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `certificate`
     */
    public CertificateClient certificate() {
        return new CertificateClient(this.executor, this.node);
    }
}