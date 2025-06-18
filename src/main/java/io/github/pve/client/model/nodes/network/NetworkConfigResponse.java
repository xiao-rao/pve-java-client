package io.github.pve.client.model.nodes.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Read network device configuration
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NetworkConfigResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("method")
    private String method;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;


}
