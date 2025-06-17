package io.github.pve.client.resource.nodes.termproxy;

import java.util.Map;
import java.util.HashMap;
import io.github.pve.client.http.ProxmoxApiExecutor;
import io.github.pve.client.http.PveResponse;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Client for /nodes/{node}/termproxy
 * BY '@xiao-rao'
 */
public class TermproxyClient {

    protected final ProxmoxApiExecutor executor;
    protected final String basePath;
    protected final String node;

    public TermproxyClient(ProxmoxApiExecutor executor, String node) {
        this.executor = executor;
        this.node = node;
        this.basePath = "/nodes/{node}/termproxy".replace("{" + "node" + "}", node);
    }

    /**
     * Creates a VNC Shell proxy.
     */
    public void termproxy(String cmd, String cmdOpts) {
        Map<String, Object> options = new HashMap<>();
        if (cmd != null) {
            options.put("cmd", cmd);
        }
        if (cmdOpts != null) {
            options.put("cmd-opts", cmdOpts);
        }
        executor.post(this.basePath, options);
    }
}