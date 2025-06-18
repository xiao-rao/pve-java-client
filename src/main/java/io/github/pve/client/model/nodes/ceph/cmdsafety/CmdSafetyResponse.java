package io.github.pve.client.model.nodes.ceph.cmdsafety;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Heuristical check if it is safe to perform an action.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CmdSafetyResponse {

    /**
     * If it is safe to run the command.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("safe")
    private Boolean safe;

    /**
     * Status message given by Ceph.
     * Type: string
     * Optional: True
     */
    @JsonProperty("status")
    private String status;


}
