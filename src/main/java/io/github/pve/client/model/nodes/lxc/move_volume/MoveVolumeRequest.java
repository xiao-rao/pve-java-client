package io.github.pve.client.model.nodes.lxc.move_volume;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;

/**
 * Move a rootfs-/mp-volume to a different storage or to a different container.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MoveVolumeRequest {

    /**
     * Override I/O bandwidth limit (in KiB/s).
     * Type: number
     * Optional: True
     */
    @JsonProperty("bwlimit")
    private Double bwlimit;

    /**
     * Delete the original volume after successful copy. By default the original is kept as an unused volume entry.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("delete")
    private Boolean delete;

    /**
     * Prevent changes if current configuration file has different SHA1 " . 		    "digest. This can be used to prevent concurrent modifications.
     * Type: string
     * Optional: True
     */
    @Size(max=40, message="Parameter 'digest' length must not exceed 40")
    @JsonProperty("digest")
    private String digest;

    /**
     * Prevent changes if current configuration file of the target " . 		    "container has a different SHA1 digest. This can be used to prevent " . 		    "concurrent modifications.
     * Type: string
     * Optional: True
     */
    @Size(max=40, message="Parameter 'target-digest' length must not exceed 40")
    @JsonProperty("target-digest")
    private String targetDigest;

    /**
     * The config key the volume will be moved to. Default is the source volume key.
     * Type: string
     * Optional: True
     */
    @JsonProperty("target-volume")
    private String targetVolume;

    /**
     * Volume which will be moved.
     * Type: string
     * Optional: True
     */
    @JsonProperty("volume")
    private String volume;

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
