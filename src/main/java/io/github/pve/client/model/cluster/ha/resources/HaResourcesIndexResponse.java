package io.github.pve.client.model.cluster.ha.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * List HA resources.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HaResourcesIndexResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("sid")
    private String sId;


}
