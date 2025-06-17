package io.github.pve.client.model.nodes.disks.zfs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * Get details about a zpool.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetailResponse {

    /**
     * Information about the recommended action to fix the state.
     * Type: string
     * Optional: True
     */
    @JsonProperty("action")
    private String action;

    /**
     * The pool configuration information, including the vdevs for each section (e.g. spares, cache), may be nested.
     * Type: array
     * Optional: True
     */
    @JsonProperty("children")
    private List<Object> children;

    /**
     * Information about the errors on the zpool.
     * Type: string
     * Optional: True
     */
    @JsonProperty("errors")
    private String errors;

    /**
     * The name of the zpool.
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;

    /**
     * Information about the last/current scrub.
     * Type: string
     * Optional: True
     */
    @JsonProperty("scan")
    private String scan;

    /**
     * The state of the zpool.
     * Type: string
     * Optional: True
     */
    @JsonProperty("state")
    private String state;

    /**
     * Information about the state of the zpool.
     * Type: string
     * Optional: True
     */
    @JsonProperty("status")
    private String status;


}
