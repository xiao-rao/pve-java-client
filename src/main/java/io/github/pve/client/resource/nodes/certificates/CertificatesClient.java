package io.github.pve.client.resource.nodes.certificates;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.certificates.acme.AcmeClient;
import io.github.pve.client.resource.nodes.certificates.info.InfoClient;
import io.github.pve.client.resource.nodes.certificates.custom.CustomClient;

/**
 * Client for /nodes/{node}/certificates
 * BY '@xiao-rao'
 */
public class CertificatesClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public CertificatesClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/certificates".replace("{node}", node);
    }

    /**
     * Node index.
     */
    public List<Object> index() {
        PveResponse<List<Object>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `acme`
     */
    public AcmeClient acme() {
        return new AcmeClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `info`
     */
    public InfoClient info() {
        return new InfoClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `custom`
     */
    public CustomClient custom() {
        return new CustomClient(this.executor, this.node);
    }
}