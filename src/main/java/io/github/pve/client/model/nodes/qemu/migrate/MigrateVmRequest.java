package io.github.pve.client.model.nodes.qemu.migrate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Migrate virtual machine. Creates a new migration task.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MigrateVmRequest {

    /**
     * Override I/O bandwidth limit (in KiB/s).
     * Type: integer
     * Optional: True
     */
    @JsonProperty("bwlimit")
    private Integer bwlimit;

    /**
     * Allow to migrate VMs which use local devices. Only root may use this option.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("force")
    private Boolean force;

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
     * Use online/live migration if VM is running. Ignored if VM is stopped.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("online")
    private Boolean online;

    /**
     * Target node.
     * Type: string
     * Optional: True
     */
    @JsonProperty("target")
    private String target;

    /**
     * Mapping from source to target storages. Providing only a single storage ID maps all source storages to that storage. Providing the special value '1' will map each source storage to itself.
     * Type: string
     * Optional: True
     */
    @JsonProperty("targetstorage")
    private String targetstorage;

    /**
     * Enable live storage migration for local disk
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("with-local-disks")
    private Boolean withLocalDisks;


}
