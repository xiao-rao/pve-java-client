package io.github.pve.client.resource.nodes.disks;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.disks.lvm.LvmClient;
import io.github.pve.client.resource.nodes.disks.lvmthin.LvmthinClient;
import io.github.pve.client.resource.nodes.disks.directory.DirectoryClient;
import io.github.pve.client.resource.nodes.disks.zfs.ZfsClient;
import io.github.pve.client.resource.nodes.disks.list.ListClient;
import io.github.pve.client.resource.nodes.disks.smart.SmartClient;
import io.github.pve.client.resource.nodes.disks.initgpt.InitgptClient;
import io.github.pve.client.resource.nodes.disks.wipedisk.WipediskClient;

/**
 * Client for /nodes/{node}/disks
 * BY '@xiao-rao'
 */
public class DisksClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public DisksClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/disks".replace("{" + "node" + "}", node);
    }

    /**
     * Node index.
     */
    public List<Object> index() {
        PveResponse<List<Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
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
     * Returns a client for the sub-resource: `directory`
     */
    public DirectoryClient directory() {
        return new DirectoryClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `zfs`
     */
    public ZfsClient zfs() {
        return new ZfsClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `list`
     */
    public ListClient list() {
        return new ListClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `smart`
     */
    public SmartClient smart() {
        return new SmartClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `initgpt`
     */
    public InitgptClient initgpt() {
        return new InitgptClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `wipedisk`
     */
    public WipediskClient wipedisk() {
        return new WipediskClient(this.executor, this.node);
    }
}