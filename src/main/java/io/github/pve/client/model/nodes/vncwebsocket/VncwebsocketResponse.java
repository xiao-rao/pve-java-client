package io.github.pve.client.model.nodes.vncwebsocket;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Opens a websocket for VNC traffic.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VncwebsocketResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("port")
    private String port;


}
