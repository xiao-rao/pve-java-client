package io.github.pve.client.model.nodes.migrateall;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Migrate all VMs and Containers.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MigrateallRequest {

    /**
     * Maximal number of parallel migration job. If not set, uses'max_workers' from datacenter.cfg. One of both must be set!
     * Type: integer
     * Optional: True
     */
    @JsonProperty("maxworkers")
    private Integer maxworkers;

    /**
     * Target node.
     * Type: string
     * Optional: True
     */
    @JsonProperty("target")
    private String target;

    /**
     * Only consider Guests with these IDs.
     * Type: string
     * Optional: True
     */
    @JsonProperty("vms")
    private String vms;

    /**
     * Enable live storage migration for local disk
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("with-local-disks")
    private Boolean withLocalDisks;


}
