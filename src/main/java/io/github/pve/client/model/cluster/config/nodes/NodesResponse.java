package io.github.pve.client.model.cluster.config.nodes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Corosync node list.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NodesResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("node")
    private String node;


}
