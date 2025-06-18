package io.github.pve.client.model.cluster.mapping.dir;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * List directory mapping
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MappingDirIndexResponse {

    /**
     * A list of checks, only present if 'check-node' is set.
     * Type: array
     * Optional: True
     */
    @JsonProperty("checks")
    private List<Object> checks;

    /**
     * A description of the logical mapping.
     * Type: string
     * Optional: True
     */
    @JsonProperty("description")
    private String description;

    /**
     * The logical ID of the mapping.
     * Type: string
     * Optional: True
     */
    @JsonProperty("id")
    private String id;

    /**
     * The entries of the mapping.
     * Type: array
     * Optional: True
     */
    @JsonProperty("map")
    private List<String> map;


}
