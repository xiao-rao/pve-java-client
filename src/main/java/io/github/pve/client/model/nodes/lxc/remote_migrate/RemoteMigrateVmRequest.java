package io.github.pve.client.model.nodes.lxc.remote_migrate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

/**
 * Migrate the container to another cluster. Creates a new migration task. EXPERIMENTAL feature!
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RemoteMigrateVmRequest {

    /**
     * Override I/O bandwidth limit (in KiB/s).
     * Type: number
     * Optional: True
     */
    @JsonProperty("bwlimit")
    private Double bwlimit;

    /**
     * Delete the original CT and related data after successful migration. By default the original CT is kept on the source cluster in a stopped state.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("delete")
    private Boolean delete;

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
     * Mapping from source to target bridges. Providing only a single bridge ID maps all source bridges to that bridge. Providing the special value '1' will map each source bridge to itself.
     * Type: string
     * Optional: True
     */
    @JsonProperty("target-bridge")
    private String targetBridge;

    /**
     * Remote target endpoint
     * Type: string
     * Optional: True
     */
    @JsonProperty("target-endpoint")
    private String targetEndpoint;

    /**
     * Mapping from source to target storages. Providing only a single storage ID maps all source storages to that storage. Providing the special value '1' will map each source storage to itself.
     * Type: string
     * Optional: False
     */
    @NotNull(message = "Parameter 'target-storage' must not be null")
    @JsonProperty("target-storage")
    private String targetStorage;

    /**
     * Timeout in seconds for shutdown for restart migration
     * Type: integer
     * Optional: True
     */
    @JsonProperty("timeout")
    private Integer timeout;

    /**
     * Path parameter: target-vmid
     * Type: string
     * Optional: True
     */
    @JsonProperty("target-vmid")
    private String targetVmid;


}
