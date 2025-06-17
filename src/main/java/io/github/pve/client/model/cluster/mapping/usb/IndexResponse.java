package io.github.pve.client.model.cluster.mapping.usb;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * List USB Hardware Mappings
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndexResponse {

    /**
     * A description of the logical mapping.
     * Type: string
     * Optional: True
     */
    @JsonProperty("description")
    private String description;

    /**
     * A list of errors when 'check_node' is given.
     * Type: string
     * Optional: True
     */
    @JsonProperty("error")
    private String error;

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
