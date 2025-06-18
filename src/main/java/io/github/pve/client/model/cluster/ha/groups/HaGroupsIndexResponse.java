package io.github.pve.client.model.cluster.ha.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Get HA groups.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HaGroupsIndexResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("group")
    private String group;


}
