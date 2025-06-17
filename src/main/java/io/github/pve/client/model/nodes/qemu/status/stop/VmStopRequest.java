package io.github.pve.client.model.nodes.qemu.status.stop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Stop virtual machine. The qemu process will exit immediately. This is akin to pulling the power plug of a running computer and may damage the VM data.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VmStopRequest {

    /**
     * Do not deactivate storage volumes.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("keepActive")
    private Boolean keepactive;

    /**
     * The cluster node name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("migratedfrom")
    private String migratedfrom;

    /**
     * Try to abort active 'qmshutdown' tasks before stopping.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("overrule-shutdown")
    private Boolean overruleShutdown;

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
