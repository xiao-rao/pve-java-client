package io.github.pve.client.model.nodes.qemu.status.shutdown;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Shutdown virtual machine. This is similar to pressing the power button on a physical machine. This will send an ACPI event for the guest OS, which should then proceed to a clean shutdown.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VmShutdownRequest {

    /**
     * Make sure the VM stops.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("forceStop")
    private Boolean forcestop;

    /**
     * Do not deactivate storage volumes.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("keepActive")
    private Boolean keepactive;

    /**
     * Ignore locks - only root is allowed to use this option.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("skiplock")
    private Boolean skiplock;

    /**
     * Wait maximal timeout seconds.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("timeout")
    private Integer timeout;


}
