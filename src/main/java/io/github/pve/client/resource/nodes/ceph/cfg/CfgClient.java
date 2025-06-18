package io.github.pve.client.resource.nodes.ceph.cfg;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.ceph.cfg.raw.RawClient;
import io.github.pve.client.resource.nodes.ceph.cfg.db.DbClient;
import io.github.pve.client.resource.nodes.ceph.cfg.value.ValueClient;

/**
 * Client for /nodes/{node}/ceph/cfg
 * BY '@xiao-rao'
 */
public class CfgClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public CfgClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/ceph/cfg".replace("{" + "node" + "}", node);
    }

    /**
     * Directory index.
     */
    public List<Object> index() {
        PveResponse<List<Object>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `raw`
     */
    public RawClient raw() {
        return new RawClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `db`
     */
    public DbClient db() {
        return new DbClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `value`
     */
    public ValueClient value() {
        return new ValueClient(this.executor, this.node);
    }
}