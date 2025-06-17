package io.github.pve.client.model.cluster.mapping.usb;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import java.util.List;
import jakarta.validation.constraints.Size;

/**
 * Create a new hardware mapping.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateRequest {

    /**
     * Description of the logical USB device.
     * Type: string
     * Optional: True
     */
    @Size(max=4096, message="Parameter 'description' length must not exceed 4096")
    @JsonProperty("description")
    private String description;

    /**
     * The ID of the logical USB mapping.
     * Type: string
     * Optional: True
     */
    @JsonProperty("id")
    private String id;

    /**
     * A list of maps for the cluster nodes.
     * Type: array
     * Optional: True
     */
    @JsonProperty("map")
    private List<String> map;


}
