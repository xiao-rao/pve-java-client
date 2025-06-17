package io.github.pve.client.model.pools;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Update pool data (deprecated, no support for nested pools - use 'PUT /pools/?poolid={poolid}' instead).
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdatePoolDeprecatedRequest {

    /**
     * Allow adding a guest even if already in another pool. The guest will be removed from its current pool and added to this one.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("allow-move")
    private Boolean allowMove;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("comment")
    private String comment;

    /**
     * Remove the passed VMIDs and/or storage IDs instead of adding them.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("delete")
    private Boolean delete;

    /**
     * List of storage IDs to add or remove from this pool.
     * Type: string
     * Optional: True
     */
    @JsonProperty("storage")
    private String storage;

    /**
     * List of guest VMIDs to add or remove from this pool.
     * Type: string
     * Optional: True
     */
    @JsonProperty("vms")
    private String vms;

    /**
     * Path parameter: poolid
     * Type: string
     * Optional: True
     */
    @JsonProperty("poolid")
    private String poolid;


}
