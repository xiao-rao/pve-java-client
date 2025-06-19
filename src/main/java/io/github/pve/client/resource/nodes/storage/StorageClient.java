package io.github.pve.client.resource.nodes.storage;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.storage.prunebackups.PrunebackupsClient;
import io.github.pve.client.resource.nodes.storage.content.ContentClient;
import io.github.pve.client.resource.nodes.storage.filerestore.FileRestoreClient;
import io.github.pve.client.resource.nodes.storage.status.StatusClient;
import io.github.pve.client.resource.nodes.storage.rrd.RrdClient;
import io.github.pve.client.resource.nodes.storage.rrddata.RrddataClient;
import io.github.pve.client.resource.nodes.storage.upload.UploadClient;
import io.github.pve.client.resource.nodes.storage.downloadurl.DownloadUrlClient;
import io.github.pve.client.resource.nodes.storage.importmetadata.ImportMetadataClient;
// Import models if needed
import io.github.pve.client.model.nodes.storage.*;

/**
 * Client for /nodes/{node}/storage
 * BY '@xiao-rao'
 */
public class StorageClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public StorageClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/storage".replace("{node}", node);
    }

    /**
     * Get status for all datastores.
     */
    public List<NodesStorageIndexResponse> index(String storage, String content, Boolean enabled, Boolean format, String target) {
        String path = this.basePath + "/" + storage;
        Map<String, Object> queryParams = new HashMap<>();
        if (content != null) {
            queryParams.put("content", content);
        }
        if (enabled != null) {
            queryParams.put("enabled", enabled);
        }
        if (format != null) {
            queryParams.put("format", format);
        }
        if (target != null) {
            queryParams.put("target", target);
        }
        PveResponse<List<NodesStorageIndexResponse>> response = executor.get(path, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * 
     */
    public List<DiridxResponse> diridx(String storage) {
        PveResponse<List<DiridxResponse>> response = executor.get(this.basePath + "/" + storage, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Client for the specific `storage` resource.
     * @param storage The path parameter `storage`.
     */
    public PrunebackupsClient prunebackups(String storage) {
        return new PrunebackupsClient(this.executor, this.node, storage);
    }

    /**
     * Client for the specific `storage` resource.
     * @param storage The path parameter `storage`.
     */
    public ContentClient content(String storage) {
        return new ContentClient(this.executor, this.node, storage);
    }

    /**
     * Client for the specific `storage` resource.
     * @param storage The path parameter `storage`.
     */
    public FileRestoreClient fileRestore(String storage) {
        return new FileRestoreClient(this.executor, this.node, storage);
    }

    /**
     * Client for the specific `storage` resource.
     * @param storage The path parameter `storage`.
     */
    public StatusClient status(String storage) {
        return new StatusClient(this.executor, this.node, storage);
    }

    /**
     * Client for the specific `storage` resource.
     * @param storage The path parameter `storage`.
     */
    public RrdClient rrd(String storage) {
        return new RrdClient(this.executor, this.node, storage);
    }

    /**
     * Client for the specific `storage` resource.
     * @param storage The path parameter `storage`.
     */
    public RrddataClient rrddata(String storage) {
        return new RrddataClient(this.executor, this.node, storage);
    }

    /**
     * Client for the specific `storage` resource.
     * @param storage The path parameter `storage`.
     */
    public UploadClient upload(String storage) {
        return new UploadClient(this.executor, this.node, storage);
    }

    /**
     * Client for the specific `storage` resource.
     * @param storage The path parameter `storage`.
     */
    public DownloadUrlClient downloadUrl(String storage) {
        return new DownloadUrlClient(this.executor, this.node, storage);
    }

    /**
     * Client for the specific `storage` resource.
     * @param storage The path parameter `storage`.
     */
    public ImportMetadataClient importMetadata(String storage) {
        return new ImportMetadataClient(this.executor, this.node, storage);
    }
}