package io.github.pve.client.resource.nodes.storage.importmetadata;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.storage.importmetadata.*;

/**
 * Client for /nodes/{node}/storage/{storage}/import-metadata
 * BY '@xiao-rao'
 */
public class ImportMetadataClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String storage;

    public ImportMetadataClient(ProxmoxApiExecutor executor, String node, String storage) {
        this.executor = executor;
        this.node = node;
        this.storage = storage;
        this.basePath = "/nodes/{node}/storage/{storage}/import-metadata".replace("{" + "node" + "}", node).replace("{" + "storage" + "}", storage);
    }

    /**
     * Get the base parameters for creating a guest which imports data from a foreign importable guest, like an ESXi VM
     */
    public GetImportMetadataResponse getImportMetadata(String volume) {
        Map<String, Object> queryParams = new HashMap<>();
        if (volume != null) {
            queryParams.put("volume", volume);
        }
        PveResponse<GetImportMetadataResponse> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}