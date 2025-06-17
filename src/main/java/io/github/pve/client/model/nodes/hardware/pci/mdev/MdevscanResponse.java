package io.github.pve.client.model.nodes.hardware.pci.mdev;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * List mediated device types for given PCI device.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MdevscanResponse {

    /**
     * The number of still available instances of this type.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("available")
    private Integer available;

    /**
     * Additional description of the type.
     * Type: string
     * Optional: True
     */
    @JsonProperty("description")
    private String description;

    /**
     * A human readable name for the type.
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;

    /**
     * The name of the mdev type.
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;


}
