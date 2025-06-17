package io.github.pve.client.model.nodes.qemu.status.suspend;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Suspend virtual machine.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VmSuspendRequest {

    /**
     * Ignore locks - only root is allowed to use this option.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("skiplock")
    private Boolean skiplock;

    /**
     * The storage for the VM state
     * Type: string
     * Optional: True
     */
    @JsonProperty("statestorage")
    private String statestorage;

    /**
     * If set, suspends the VM to disk. Will be resumed on next VM start.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("todisk")
    private Boolean todisk;


}
