package io.github.pve.client.model.cluster.ceph.flags;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * get the status of all ceph flags
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetAllFlagsResponse {

    /**
     * Flag description.
     * Type: string
     * Optional: True
     */
    @JsonProperty("description")
    private String description;

    /**
     * Flag name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;

    /**
     * Flag value.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("value")
    private Boolean value;


}
