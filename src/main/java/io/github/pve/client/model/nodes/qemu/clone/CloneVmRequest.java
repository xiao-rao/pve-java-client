package io.github.pve.client.model.nodes.qemu.clone;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;

/**
 * Create a copy of virtual machine/template.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CloneVmRequest {

    /**
     * Override I/O bandwidth limit (in KiB/s).
     * Type: integer
     * Optional: True
     */
    @JsonProperty("bwlimit")
    private Integer bwlimit;

    /**
     * Description for the new VM.
     * Type: string
     * Optional: True
     */
    @JsonProperty("description")
    private String description;

    /**
     * Target format for file storage. Only valid for full clone.
     * Type: string
     * Optional: True
     */
    @JsonProperty("format")
    private String format;

    /**
     * Create a full copy of all disks. This is always done when you clone a normal VM. For VM templates, we try to create a linked clone by default.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("full")
    private Boolean full;

    /**
     * Set a name for the new VM.
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;

    /**
     * Add the new VM to the specified pool.
     * Type: string
     * Optional: True
     */
    @JsonProperty("pool")
    private String pool;

    /**
     * The name of the snapshot.
     * Type: string
     * Optional: True
     */
    @Size(max=40, message="Parameter 'snapname' length must not exceed 40")
    @JsonProperty("snapname")
    private String snapname;

    /**
     * Target node. Only allowed if the original VM is on shared storage.
     * Type: string
     * Optional: True
     */
    @JsonProperty("target")
    private String target;

    /**
     * Path parameter: newid
     * Type: string
     * Optional: True
     */
    @JsonProperty("newid")
    private String newid;

    /**
     * Path parameter: storage
     * Type: string
     * Optional: True
     */
    @JsonProperty("storage")
    private String storage;


}
