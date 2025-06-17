package io.github.pve.client.model.nodes.qemu.pending;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Get the virtual machine configuration with both current and pending values.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VmPendingResponse {

    /**
     * Indicates a pending delete request if present and not 0. The value 2 indicates a force-delete request.
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
     * Pending value.
     * Type: string
     * Optional: True
     */
    @JsonProperty("pending")
    private String pending;

    /**
     * Current value.
     * Type: string
     * Optional: True
     */
    @JsonProperty("value")
    private String value;


}
