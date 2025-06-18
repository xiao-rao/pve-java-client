package io.github.pve.client.model.nodes.storage;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Get status for all datastores.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NodesStorageIndexResponse {

    /**
     * Set when storage is accessible.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("active")
    private Boolean active;

    /**
     * Available storage space in bytes.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("avail")
    private Integer avail;

    /**
     * Allowed storage content types.
     * Type: string
     * Optional: True
     */
    @JsonProperty("content")
    private String content;

    /**
     * Set when storage is enabled (not disabled).
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("enabled")
    private Boolean enabled;

    /**
     * Shared flag from storage configuration.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("shared")
    private Boolean shared;

    /**
     * The storage identifier.
     * Type: string
     * Optional: True
     */
    @JsonProperty("storage")
    private String storage;

    /**
     * Total storage space in bytes.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("total")
    private Integer total;

    /**
     * Storage type.
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;

    /**
     * Used storage space in bytes.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("used")
    private Integer used;

    /**
     * Used fraction (used/total).
     * Type: number
     * Optional: True
     */
    @JsonProperty("used_fraction")
    private Double usedFraction;


}
