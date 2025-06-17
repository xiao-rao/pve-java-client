package io.github.pve.client.resource.nodes.storage.content;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
// Import models if needed
import io.github.pve.client.model.nodes.storage.content.*;

/**
 * Client for /nodes/{node}/storage/{storage}/content
 * BY '@xiao-rao'
 */
public class ContentClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String storage;

    public ContentClient(ProxmoxApiExecutor executor, String node, String storage) {
        this.executor = executor;
        this.node = node;
        this.storage = storage;
        this.basePath = "/nodes/{node}/storage/{storage}/content".replace("{" + "node" + "}", node).replace("{" + "storage" + "}", storage);
    }

    /**
     * List storage content.
     */
    public IndexResponse index(String vmid, String content) {
        String path = this.basePath + "/" + vmid;
        Map<String, Object> queryParams = new HashMap<>();
        if (content != null) {
            queryParams.put("content", content);
        }
        PveResponse<IndexResponse> response = executor.get(path, queryParams, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Allocate disk images.
     */
    public String create(CreateRequest request) {
        PveResponse<String> response = executor.post(this.basePath + "/" + request.getVmid(), request, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Delete volume
     */
    public void delete(String volume, Integer delay) {
        String path = this.basePath + "/" + volume;
        Map<String, Object> options = new HashMap<>();
        if (delay != null) {
            options.put("delay", delay);
        }
        executor.delete(path, options);
    }

    /**
     * Get volume attributes
     */
    public InfoResponse info(String volume) {
        PveResponse<InfoResponse> response = executor.get(this.basePath + "/" + volume, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Copy a volume. This is experimental code - do not use.
     */
    public void copy(String volume, String target, String targetNode) {
        String path = this.basePath + "/" + volume;
        Map<String, Object> options = new HashMap<>();
        if (target != null) {
            options.put("target", target);
        }
        if (targetNode != null) {
            options.put("target_node", targetNode);
        }
        executor.post(path, options);
    }

    /**
     * Update volume attributes
     */
    public void updateattributes(String volume, String notes, Boolean protectedValue) {
        String path = this.basePath + "/" + volume;
        Map<String, Object> options = new HashMap<>();
        if (notes != null) {
            options.put("notes", notes);
        }
        if (protectedValue != null) {
            options.put("protected", protectedValue);
        }
        executor.put(path, options);
    }
}