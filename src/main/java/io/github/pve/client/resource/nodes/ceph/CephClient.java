package io.github.pve.client.resource.nodes.ceph;

import java.util.List;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.pve.client.resource.nodes.ceph.cfg.CfgClient;
import io.github.pve.client.resource.nodes.ceph.osd.OsdClient;
import io.github.pve.client.resource.nodes.ceph.mds.MdsClient;
import io.github.pve.client.resource.nodes.ceph.mgr.MgrClient;
import io.github.pve.client.resource.nodes.ceph.mon.MonClient;
import io.github.pve.client.resource.nodes.ceph.fs.FsClient;
import io.github.pve.client.resource.nodes.ceph.pool.PoolClient;
import io.github.pve.client.resource.nodes.ceph.init.InitClient;
import io.github.pve.client.resource.nodes.ceph.stop.StopClient;
import io.github.pve.client.resource.nodes.ceph.start.StartClient;
import io.github.pve.client.resource.nodes.ceph.restart.RestartClient;
import io.github.pve.client.resource.nodes.ceph.status.StatusClient;
import io.github.pve.client.resource.nodes.ceph.crush.CrushClient;
import io.github.pve.client.resource.nodes.ceph.log.LogClient;
import io.github.pve.client.resource.nodes.ceph.rules.RulesClient;
import io.github.pve.client.resource.nodes.ceph.cmdsafety.CmdSafetyClient;

/**
 * Client for /nodes/{node}/ceph
 * BY '@xiao-rao'
 */
public class CephClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public CephClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/ceph".replace("{" + "node" + "}", node);
    }

    /**
     * Directory index.
     */
    public List<Object> index() {
        PveResponse<List<Object>> response = executor.get(this.basePath, null, new TypeReference<>() {});
        return response.getData().orElse(null);
    }

    /**
     * Returns a client for the sub-resource: `cfg`
     */
    public CfgClient cfg() {
        return new CfgClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `osd`
     */
    public OsdClient osd() {
        return new OsdClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `mds`
     */
    public MdsClient mds() {
        return new MdsClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `mgr`
     */
    public MgrClient mgr() {
        return new MgrClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `mon`
     */
    public MonClient mon() {
        return new MonClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `fs`
     */
    public FsClient fs() {
        return new FsClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `pool`
     */
    public PoolClient pool() {
        return new PoolClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `init`
     */
    public InitClient init() {
        return new InitClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `stop`
     */
    public StopClient stop() {
        return new StopClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `start`
     */
    public StartClient start() {
        return new StartClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `restart`
     */
    public RestartClient restart() {
        return new RestartClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `status`
     */
    public StatusClient status() {
        return new StatusClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `crush`
     */
    public CrushClient crush() {
        return new CrushClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `log`
     */
    public LogClient log() {
        return new LogClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `rules`
     */
    public RulesClient rules() {
        return new RulesClient(this.executor, this.node);
    }

    /**
     * Returns a client for the sub-resource: `cmdSafety`
     */
    public CmdSafetyClient cmdSafety() {
        return new CmdSafetyClient(this.executor, this.node);
    }
}