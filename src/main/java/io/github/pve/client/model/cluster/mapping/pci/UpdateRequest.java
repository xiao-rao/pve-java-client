package io.github.pve.client.model.cluster.mapping.pci;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import java.util.List;
import jakarta.validation.constraints.Size;

/**
 * Update a hardware mapping.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateRequest {

    /**
     * A list of settings you want to delete.
     * Type: string
     * Optional: True
     */
    @Size(max=4096, message="Parameter 'delete' length must not exceed 4096")
    @JsonProperty("delete")
    private String delete;

    /**
     * Description of the logical PCI device.
     * Type: string
     * Optional: True
     */
    @Size(max=4096, message="Parameter 'description' length must not exceed 4096")
    @JsonProperty("description")
    private String description;

    /**
     * Prevent changes if current configuration file has a different digest. This can be used to prevent concurrent modifications.
     * Type: string
     * Optional: True
     */
    @Size(max=64, message="Parameter 'digest' length must not exceed 64")
    @JsonProperty("digest")
    private String digest;

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
     * Optional: True
     */
    @JsonProperty("map")
    private List<String> map;

    /**
     * Marks the device(s) as being capable of providing mediated devices.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("mdev")
    private Boolean mdev;

    /**
     * Path parameter: id
     * Type: string
     * Optional: True
     */
    @JsonProperty("id")
    private String id;


}
