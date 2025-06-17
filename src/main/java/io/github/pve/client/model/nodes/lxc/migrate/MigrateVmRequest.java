package io.github.pve.client.model.nodes.lxc.migrate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Migrate the container to another node. Creates a new migration task.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MigrateVmRequest {

    /**
     * Override I/O bandwidth limit (in KiB/s).
     * Type: number
     * Optional: True
     */
    @JsonProperty("bwlimit")
    private Double bwlimit;

    /**
     * Use online/live migration.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("online")
    private Boolean online;

    /**
     * Use restart migration
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("restart")
    private Boolean restart;

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
    @JsonProperty("target-storage")
    private String targetStorage;

    /**
     * Timeout in seconds for shutdown for restart migration
     * Type: integer
     * Optional: True
     */
    @JsonProperty("timeout")
    private Integer timeout;


}
