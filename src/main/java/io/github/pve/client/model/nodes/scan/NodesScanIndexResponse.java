package io.github.pve.client.model.nodes.scan;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Index of available scan methods
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NodesScanIndexResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("method")
    private String method;


}
