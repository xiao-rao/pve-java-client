package io.github.pve.client.model.pools;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * List pools or get pool configuration.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PoolsIndexResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("comment")
    private String comment;

    /**
     * 
     * Type: array
     * Optional: True
     */
    @JsonProperty("members")
    private List<Object> members;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("poolid")
    private String poolId;


}
