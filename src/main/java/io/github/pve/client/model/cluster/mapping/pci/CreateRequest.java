package io.github.pve.client.model.cluster.mapping.pci;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import java.util.List;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

/**
 * Create a new hardware mapping.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateRequest {

    /**
     * Description of the logical PCI device.
     * Type: string
     * Optional: True
     */
    @Size(max=4096, message="Parameter 'description' length must not exceed 4096")
    @JsonProperty("description")
    private String description;

    /**
     * The ID of the logical PCI mapping.
     * Type: string
     * Optional: True
     */
    @JsonProperty("id")
    private String id;

    /**
     * Marks the device(s) as being able to be live-migrated (Experimental). This needs hardware and driver support to work.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("live-migration-capable")
    private Boolean liveMigrationCapable;

    /**
     * A list of maps for the cluster nodes.
     * Type: array
     * Optional: False
     */
    @NotNull(message = "Parameter 'map' must not be null")
    @JsonProperty("map")
    private List<String> map;

    /**
     * Marks the device(s) as being capable of providing mediated devices.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("mdev")
    private Boolean mdev;


}
