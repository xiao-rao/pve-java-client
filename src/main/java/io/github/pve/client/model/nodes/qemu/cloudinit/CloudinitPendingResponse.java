package io.github.pve.client.model.nodes.qemu.cloudinit;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Get the cloudinit configuration with both current and pending values.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CloudinitPendingResponse {

    /**
     * Indicates a pending delete request if present and not 0. 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("delete")
    private Integer delete;

    /**
     * Configuration option name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("key")
    private String key;

    /**
     * The new pending value.
     * Type: string
     * Optional: True
     */
    @JsonProperty("pending")
    private String pending;

    /**
     * Value as it was used to generate the current cloudinit image.
     * Type: string
     * Optional: True
     */
    @JsonProperty("value")
    private String value;


}
