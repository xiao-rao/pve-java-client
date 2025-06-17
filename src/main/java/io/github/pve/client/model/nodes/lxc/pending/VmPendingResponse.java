package io.github.pve.client.model.nodes.lxc.pending;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Get container configuration, including pending changes.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VmPendingResponse {

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
