package io.github.pve.client.model.nodes.qemu.snapshot;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * List all snapshots.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SnapshotListResponse {

    /**
     * Snapshot description.
     * Type: string
     * Optional: True
     */
    @JsonProperty("description")
    private String description;

    /**
     * Snapshot identifier. Value 'current' identifies the current VM.
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;

    /**
     * Parent snapshot identifier.
     * Type: string
     * Optional: True
     */
    @JsonProperty("parent")
    private String parent;

    /**
     * Snapshot creation time
     * Type: integer
     * Optional: True
     */
    @JsonProperty("snaptime")
    private Integer snaptime;

    /**
     * Snapshot includes RAM.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("vmstate")
    private Boolean vmstate;


}
