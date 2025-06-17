package io.github.pve.client.model.nodes.vncshell;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Creates a VNC Shell proxy.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VncshellRequest {

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
     * sets the height of the console in pixels.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("height")
    private Integer height;

    /**
     * use websocket instead of standard vnc.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("websocket")
    private Boolean websocket;

    /**
     * sets the width of the console in pixels.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("width")
    private Integer width;


}
