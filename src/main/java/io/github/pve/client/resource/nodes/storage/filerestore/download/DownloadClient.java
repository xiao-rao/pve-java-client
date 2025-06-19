package io.github.pve.client.resource.nodes.storage.filerestore.download;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/storage/{storage}/file-restore/download
 * BY '@xiao-rao'
 */
public class DownloadClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String storage;

    public DownloadClient(ProxmoxApiExecutor executor, String node, String storage) {
        this.executor = executor;
        this.node = node;
        this.storage = storage;
        this.basePath = "/nodes/{node}/storage/{storage}/file-restore/download".replace("{node}", node).replace("{storage}", storage);
    }

    /**
     * Extract a file or directory (as zip archive) from a PBS backup.
     */
    public Object download(String filepath, Boolean tar, String volume) {
        Map<String, Object> queryParams = new HashMap<>();
        if (filepath != null) {
            queryParams.put("filepath", filepath);
        }
        if (tar != null) {
            queryParams.put("tar", tar);
        }
        if (volume != null) {
            queryParams.put("volume", volume);
        }
        PveResponse<Object> response = executor.get(this.basePath, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }
}