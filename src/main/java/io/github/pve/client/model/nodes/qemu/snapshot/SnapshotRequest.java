package io.github.pve.client.model.nodes.qemu.snapshot;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;

/**
 * Snapshot a VM.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SnapshotRequest {

    /**
     * A textual description or comment.
     * Type: string
     * Optional: True
     */
    @JsonProperty("description")
    private String description;

    /**
     * The name of the snapshot.
     * Type: string
     * Optional: True
     */
    @Size(max=40, message="Parameter 'snapname' length must not exceed 40")
    @JsonProperty("snapname")
    private String snapname;

    /**
     * Save the vmstate
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("vmstate")
    private Boolean vmstate;


}
