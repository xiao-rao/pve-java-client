package io.github.pve.client.resource.nodes.storage.filerestore;

import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.storage.filerestore.list.ListClient;
import io.github.pve.client.resource.nodes.storage.filerestore.download.DownloadClient;

/**
 * Client for /nodes/{node}/storage/{storage}/file-restore
 * BY '@xiao-rao'
 */
public class FileRestoreClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String storage;

    public FileRestoreClient(ProxmoxApiExecutor executor, String node, String storage) {
        this.executor = executor;
        this.node = node;
        this.storage = storage;
        this.basePath = "/nodes/{node}/storage/{storage}/file-restore".replace("{node}", node).replace("{storage}", storage);
    }


    /**
     * Returns a client for the sub-resource: `list`
     */
    public ListClient list() {
        return new ListClient(this.executor, this.node, this.storage);
    }

    /**
     * Returns a client for the sub-resource: `download`
     */
    public DownloadClient download() {
        return new DownloadClient(this.executor, this.node, this.storage);
    }
}