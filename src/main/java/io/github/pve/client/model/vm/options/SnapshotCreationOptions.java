package io.github.pve.client.model.vm.options;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 创建快照时的参数选项
 * Corresponds to parameters for POST /nodes/{node}/qemu/{vmid}/snapshot
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SnapshotCreationOptions {
    /**
     * The snapshot name.
     */
    @JsonProperty("snapname")
    private String snapshotName;

    /**
     * A description for the snapshot.
     */
    private String description;

    /**
     * Include RAM in the snapshot.
     */
    @JsonProperty("vmstate")
    private Boolean vmState;
}

