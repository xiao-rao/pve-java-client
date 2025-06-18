package io.github.pve.client.model.nodes.replication;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * List status of all replication jobs on this node.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("id")
    private String id;


}
