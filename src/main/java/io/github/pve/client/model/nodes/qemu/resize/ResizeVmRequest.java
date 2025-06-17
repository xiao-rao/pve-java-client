package io.github.pve.client.model.nodes.qemu.resize;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

/**
 * Extend volume size.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResizeVmRequest {

    /**
     * Prevent changes if current configuration file has different SHA1 digest. This can be used to prevent concurrent modifications.
     * Type: string
     * Optional: True
     */
    @Size(max=40, message="Parameter 'digest' length must not exceed 40")
    @JsonProperty("digest")
    private String digest;

    /**
     * The disk you want to resize.
     * Type: string
     * Optional: True
     */
    @JsonProperty("disk")
    private String disk;

    /**
     * The new size. With the `+` sign the value is added to the actual size of the volume and without it, the value is taken as an absolute one. Shrinking disk size is not supported.
     * Type: string
     * Optional: True
     */
    @Pattern(regexp="\\+?\\d+(\\.\\d+)?[KMGT]?", message="Parameter 'size' does not match pattern")
    @JsonProperty("size")
    private String size;

    /**
     * Ignore locks - only root is allowed to use this option.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("skiplock")
    private Boolean skiplock;


}
