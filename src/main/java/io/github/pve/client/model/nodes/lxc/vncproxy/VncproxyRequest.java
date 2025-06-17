package io.github.pve.client.model.nodes.lxc.vncproxy;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Creates a TCP VNC proxy connections.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VncproxyRequest {

    /**
     * sets the height of the console in pixels.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("height")
    private Integer height;

    /**
     * use websocket instead of standard VNC.
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
