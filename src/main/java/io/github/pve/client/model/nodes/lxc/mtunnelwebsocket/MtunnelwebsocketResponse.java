package io.github.pve.client.model.nodes.lxc.mtunnelwebsocket;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Migration tunnel endpoint for websocket upgrade - only for internal use by VM migration.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MtunnelwebsocketResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("port")
    private String port;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("socket")
    private String socket;


}
