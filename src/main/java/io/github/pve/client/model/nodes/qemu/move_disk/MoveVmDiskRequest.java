package io.github.pve.client.model.nodes.qemu.move_disk;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;

/**
 * Move volume to different storage or to a different VM.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MoveVmDiskRequest {

    /**
     * Override I/O bandwidth limit (in KiB/s).
     * Type: integer
     * Optional: True
     */
    @JsonProperty("bwlimit")
    private Integer bwlimit;

    /**
     * Delete the original disk after successful copy. By default the original disk is kept as unused disk.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("delete")
    private Boolean delete;

    /**
     * Prevent changes if current configuration file has different SHA1" 		    ." digest. This can be used to prevent concurrent modifications.
     * Type: string
     * Optional: True
     */
    @Size(max=40, message="Parameter 'digest' length must not exceed 40")
    @JsonProperty("digest")
    private String digest;

    /**
     * The disk you want to move.
     * Type: string
     * Optional: True
     */
    @JsonProperty("disk")
    private String disk;

    /**
     * Target Format.
     * Type: string
     * Optional: True
     */
    @JsonProperty("format")
    private String format;

    /**
     * Prevent changes if the current config file of the target VM has a" 		    ." different SHA1 digest. This can be used to detect concurrent modifications.
     * Type: string
     * Optional: True
     */
    @Size(max=40, message="Parameter 'target-digest' length must not exceed 40")
    @JsonProperty("target-digest")
    private String targetDigest;

    /**
     * The config key the disk will be moved to on the target VM (for example, ide0 or scsi1). Default is the source disk key.
     * Type: string
     * Optional: True
     */
    @JsonProperty("target-disk")
    private String targetDisk;

    /**
     * Path parameter: storage
     * Type: string
     * Optional: True
     */
    @JsonProperty("storage")
    private String storage;

    /**
     * Path parameter: target-vmid
     * Type: string
     * Optional: True
     */
    @JsonProperty("target-vmid")
    private String targetVmId;


}
