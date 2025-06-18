package io.github.pve.client.model.pools;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * Get pool configuration (deprecated, no support for nested pools, use 'GET /pools/?poolid={poolid}').
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReadPoolResponse {

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


}
