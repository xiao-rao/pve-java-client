package io.github.pve.client.model.nodes.stopall;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Stop all VMs and Containers.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StopallRequest {

    /**
     * Force a hard-stop after the timeout.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("force-stop")
    private Boolean forceStop;

    /**
     * Timeout for each guest shutdown task. Depending on `force-stop`, the shutdown gets then simply aborted or a hard-stop is forced.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("timeout")
    private Integer timeout;

    /**
     * Only consider Guests with these IDs.
     * Type: string
     * Optional: True
     */
    @JsonProperty("vms")
    private String vms;


}
