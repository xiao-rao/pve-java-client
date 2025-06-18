package io.github.pve.client.model.nodes.qemu.vncwebsocket;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Opens a weksocket for VNC traffic.
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
