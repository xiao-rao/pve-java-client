package io.github.pve.client.model.nodes.qemu.status.start;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;

/**
 * Start virtual machine.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VmStartRequest {

    /**
     * Override QEMU's -cpu argument with the given string.
     * Type: string
     * Optional: True
     */
    @JsonProperty("force-cpu")
    private String forceCpu;

    /**
     * Specify the QEMU machine.
     * Type: string
     * Optional: True
     */
    @JsonProperty("machine")
    private String machine;

    /**
     * The cluster node name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("migratedfrom")
    private String migratedfrom;

    /**
     * CIDR of the (sub) network that is used for migration.
     * Type: string
     * Optional: True
     */
    @JsonProperty("migration_network")
    private String migrationNetwork;

    /**
     * Migration traffic is encrypted using an SSH tunnel by default. On secure, completely private networks this can be disabled to increase performance.
     * Type: string
     * Optional: True
     */
    @JsonProperty("migration_type")
    private String migrationType;

    /**
     * Ignore locks - only root is allowed to use this option.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("skiplock")
    private Boolean skiplock;

    /**
     * Some command save/restore state from this location.
     * Type: string
     * Optional: True
     */
    @Size(max=128, message="Parameter 'stateuri' length must not exceed 128")
    @JsonProperty("stateuri")
    private String stateuri;

    /**
     * Mapping from source to target storages. Providing only a single storage ID maps all source storages to that storage. Providing the special value '1' will map each source storage to itself.
     * Type: string
     * Optional: True
     */
    @JsonProperty("targetstorage")
    private String targetstorage;

    /**
     * Wait maximal timeout seconds.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("timeout")
    private Integer timeout;


}
