package io.github.pve.client.resource.nodes.ceph.fs;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/ceph/fs
 * BY '@xiao-rao'
 */
public class FsClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public FsClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/ceph/fs".replace("{" + "node" + "}", node);
    }

    /**
     * Directory index.
     */
    public List<Object> index() {
        PveResponse<List<Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Create a Ceph filesystem
     */
    public void createfs(String name, Boolean addStorage, Integer pgNum) {
        String path = this.basePath + "/" + name;
        Map<String, Object> options = new HashMap<>();
        if (addStorage != null) {
            options.put("add-storage", addStorage);
        }
        if (pgNum != null) {
            options.put("pg_num", pgNum);
        }
        executor.post(path, options);
    }
}