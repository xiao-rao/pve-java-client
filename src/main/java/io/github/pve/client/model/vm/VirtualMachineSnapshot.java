package io.github.pve.client.model.vm;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 虚拟机快照信息
 * Corresponds to an item in the response from GET /nodes/{node}/qemu/{vmid}/snapshot
 */
@Data
public class VirtualMachineSnapshot {
    /**
     * Snapshot name.
     */
    private String name;

    /**
     * Snapshot description.
     */
    private String description;

    /**
     * The parent snapshot name.
     */
    private String parent;

    /**
     * Snapshot creation time (epoch).
     */
    @JsonProperty("snaptime")
    private Long snapTime;

    /**
     * Indicates if the snapshot includes the RAM state.
     */
    @JsonProperty("vmstate")
    private Integer vmState;
}

