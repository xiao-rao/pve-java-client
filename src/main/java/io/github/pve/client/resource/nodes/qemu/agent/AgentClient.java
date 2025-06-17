package io.github.pve.client.resource.nodes.qemu.agent;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.qemu.agent.fsfreezefreeze.FsfreezeFreezeClient;
import io.github.pve.client.resource.nodes.qemu.agent.fsfreezestatus.FsfreezeStatusClient;
import io.github.pve.client.resource.nodes.qemu.agent.fsfreezethaw.FsfreezeThawClient;
import io.github.pve.client.resource.nodes.qemu.agent.fstrim.FstrimClient;
import io.github.pve.client.resource.nodes.qemu.agent.getfsinfo.GetFsinfoClient;
import io.github.pve.client.resource.nodes.qemu.agent.gethostname.GetHostNameClient;
import io.github.pve.client.resource.nodes.qemu.agent.getmemoryblockinfo.GetMemoryBlockInfoClient;
import io.github.pve.client.resource.nodes.qemu.agent.getmemoryblocks.GetMemoryBlocksClient;
import io.github.pve.client.resource.nodes.qemu.agent.getosinfo.GetOsinfoClient;
import io.github.pve.client.resource.nodes.qemu.agent.gettime.GetTimeClient;
import io.github.pve.client.resource.nodes.qemu.agent.gettimezone.GetTimezoneClient;
import io.github.pve.client.resource.nodes.qemu.agent.getusers.GetUsersClient;
import io.github.pve.client.resource.nodes.qemu.agent.getvcpus.GetVcpusClient;
import io.github.pve.client.resource.nodes.qemu.agent.info.InfoClient;
import io.github.pve.client.resource.nodes.qemu.agent.networkgetinterfaces.NetworkGetInterfacesClient;
import io.github.pve.client.resource.nodes.qemu.agent.ping.PingClient;
import io.github.pve.client.resource.nodes.qemu.agent.shutdown.ShutdownClient;
import io.github.pve.client.resource.nodes.qemu.agent.suspenddisk.SuspendDiskClient;
import io.github.pve.client.resource.nodes.qemu.agent.suspendhybrid.SuspendHybridClient;
import io.github.pve.client.resource.nodes.qemu.agent.suspendram.SuspendRamClient;
import io.github.pve.client.resource.nodes.qemu.agent.setuserpassword.SetUserPasswordClient;
import io.github.pve.client.resource.nodes.qemu.agent.exec.ExecClient;
import io.github.pve.client.resource.nodes.qemu.agent.execstatus.ExecStatusClient;
import io.github.pve.client.resource.nodes.qemu.agent.fileread.FileReadClient;
import io.github.pve.client.resource.nodes.qemu.agent.filewrite.FileWriteClient;

/**
 * Client for /nodes/{node}/qemu/{vmid}/agent
 * BY '@xiao-rao'
 */
public class AgentClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;
    protected final String vmid;

    public AgentClient(ProxmoxApiExecutor executor, String node, String vmid) {
        this.executor = executor;
        this.node = node;
        this.vmid = vmid;
        this.basePath = "/nodes/{node}/qemu/{vmid}/agent".replace("{" + "node" + "}", node).replace("{" + "vmid" + "}", vmid);
    }

    /**
     * QEMU Guest Agent command index.
     */
    public List<Object> index() {
        PveResponse<List<Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Execute QEMU Guest Agent commands.
     */
    public Map<String, Object> agent(String command) {
        Map<String, Object> options = new HashMap<>();
        if (command != null) {
            options.put("command", command);
        }
        PveResponse<Map<String, Object>> response = executor.post(this.basePath, options, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `fsfreezeFreeze`
     */
    public FsfreezeFreezeClient fsfreezeFreeze() {
        return new FsfreezeFreezeClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `fsfreezeStatus`
     */
    public FsfreezeStatusClient fsfreezeStatus() {
        return new FsfreezeStatusClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `fsfreezeThaw`
     */
    public FsfreezeThawClient fsfreezeThaw() {
        return new FsfreezeThawClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `fstrim`
     */
    public FstrimClient fstrim() {
        return new FstrimClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `getFsinfo`
     */
    public GetFsinfoClient getFsinfo() {
        return new GetFsinfoClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `getHostName`
     */
    public GetHostNameClient getHostName() {
        return new GetHostNameClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `getMemoryBlockInfo`
     */
    public GetMemoryBlockInfoClient getMemoryBlockInfo() {
        return new GetMemoryBlockInfoClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `getMemoryBlocks`
     */
    public GetMemoryBlocksClient getMemoryBlocks() {
        return new GetMemoryBlocksClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `getOsinfo`
     */
    public GetOsinfoClient getOsinfo() {
        return new GetOsinfoClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `getTime`
     */
    public GetTimeClient getTime() {
        return new GetTimeClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `getTimezone`
     */
    public GetTimezoneClient getTimezone() {
        return new GetTimezoneClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `getUsers`
     */
    public GetUsersClient getUsers() {
        return new GetUsersClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `getVcpus`
     */
    public GetVcpusClient getVcpus() {
        return new GetVcpusClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `info`
     */
    public InfoClient info() {
        return new InfoClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `networkGetInterfaces`
     */
    public NetworkGetInterfacesClient networkGetInterfaces() {
        return new NetworkGetInterfacesClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `ping`
     */
    public PingClient ping() {
        return new PingClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `shutdown`
     */
    public ShutdownClient shutdown() {
        return new ShutdownClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `suspendDisk`
     */
    public SuspendDiskClient suspendDisk() {
        return new SuspendDiskClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `suspendHybrid`
     */
    public SuspendHybridClient suspendHybrid() {
        return new SuspendHybridClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `suspendRam`
     */
    public SuspendRamClient suspendRam() {
        return new SuspendRamClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `setUserPassword`
     */
    public SetUserPasswordClient setUserPassword() {
        return new SetUserPasswordClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `exec`
     */
    public ExecClient exec() {
        return new ExecClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `execStatus`
     */
    public ExecStatusClient execStatus() {
        return new ExecStatusClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `fileRead`
     */
    public FileReadClient fileRead() {
        return new FileReadClient(this.executor, this.node, this.vmid);
    }

    /**
     * Returns a client for the sub-resource: `fileWrite`
     */
    public FileWriteClient fileWrite() {
        return new FileWriteClient(this.executor, this.node, this.vmid);
    }
}