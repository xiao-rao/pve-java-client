package io.github.pve.client.resource.nodes.scan;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.scan.nfs.NfsClient;
import io.github.pve.client.resource.nodes.scan.cifs.CifsClient;
import io.github.pve.client.resource.nodes.scan.pbs.PbsClient;
import io.github.pve.client.resource.nodes.scan.glusterfs.GlusterfsClient;
import io.github.pve.client.resource.nodes.scan.iscsi.IscsiClient;
import io.github.pve.client.resource.nodes.scan.lvm.LvmClient;
import io.github.pve.client.resource.nodes.scan.lvmthin.LvmthinClient;
import io.github.pve.client.resource.nodes.scan.zfs.ZfsClient;
// Import models if needed
import io.github.pve.client.model.nodes.scan.*;

/**
 * Client for /nodes/{node}/scan
 * BY '@xiao-rao'
 */
public class ScanClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public ScanClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/scan".replace("{" + "node" + "}", node);
    }

    /**
     * Index of available scan methods
     */
    public List<NodesScanIndexResponse> index() {
        PveResponse<List<NodesScanIndexResponse>> response = executor.get(this.basePath, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `nfs`
     */
    public NfsClient nfs() {
        return new NfsClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `cifs`
     */
    public CifsClient cifs() {
        return new CifsClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `pbs`
     */
    public PbsClient pbs() {
        return new PbsClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `glusterfs`
     */
    public GlusterfsClient glusterfs() {
        return new GlusterfsClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `iscsi`
     */
    public IscsiClient iscsi() {
        return new IscsiClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `lvm`
     */
    public LvmClient lvm() {
        return new LvmClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `lvmthin`
     */
    public LvmthinClient lvmthin() {
        return new LvmthinClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `zfs`
     */
    public ZfsClient zfs() {
        return new ZfsClient(this.executor, this.node);
    }
}