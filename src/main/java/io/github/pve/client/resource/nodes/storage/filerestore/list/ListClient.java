package io.github.pve.client.resource.nodes.storage.filerestore.list;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.storage.filerestore.list.*;

/**
 * Client for /nodes/{node}/storage/{storage}/file-restore/list
 * BY '@xiao-rao'
 */
public class ListClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String storage;

    public ListClient(ProxmoxApiExecutor executor, String node, String storage) {
        this.executor = executor;
        this.node = node;
        this.storage = storage;
        this.basePath = "/nodes/{node}/storage/{storage}/file-restore/list".replace("{node}", node).replace("{storage}", storage);
    }

    /**
     * List files and directories for single file restore under the given path.
     */
    public List<ListResponse> list(String filepath, String volume) {
        Map<String, Object> queryParams = new HashMap<>();
        if (filepath != null) {
            queryParams.put("filepath", filepath);
        }
        if (volume != null) {
            queryParams.put("volume", volume);
        }
        PveResponse<List<ListResponse>> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}