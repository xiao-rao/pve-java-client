package io.github.pve.client.model.nodes.spiceshell;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Creates a SPICE shell.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SpiceshellRequest {

    /**
     * Run specific command or default to login (requires 'root@pam')
     * Type: string
     * Optional: True
     */
    @JsonProperty("cmd")
    private String cmd;

    /**
     * Add parameters to a command. Encoded as null terminated strings.
     * Type: string
     * Optional: True
     */
    @JsonProperty("cmd-opts")
    private String cmdOpts;

    /**
     * SPICE proxy server. This can be used by the client to specify the proxy server. All nodes in a cluster runs 'spiceproxy', so it is up to the client to choose one. By default, we return the node where the VM is currently running. As reasonable setting is to use same node you use to connect to the API (This is window.location.hostname for the JS GUI).
     * Type: string
     * Optional: True
     */
    @JsonProperty("proxy")
    private String proxy;


}
