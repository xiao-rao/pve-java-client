package io.github.pve.client.model.nodes.qemu.migrate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Get preconditions for migration.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MigrateVmPreconditionResponse {

    /**
     * List of nodes allowed for migration.
     * Type: array
     * Optional: True
     */
    @JsonProperty("allowed_nodes")
    private List<String> allowedNodes;

    /**
     * List local disks including CD-Rom, unused and not referenced disks
     * Type: array
     * Optional: True
     */
    @JsonProperty("local_disks")
    private List<Object> localDisks;

    /**
     * List local resources (e.g. pci, usb) that block migration.
     * Type: array
     * Optional: True
     */
    @JsonProperty("local_resources")
    private List<String> localResources;

    /**
     * Object of mapped resources with additional information such if they're live migratable.
     * Type: object
     * Optional: True
     */
    @JsonProperty("mapped-resource-info")
    private Map<String, Object> mappedResourceInfo;

    /**
     * List of mapped resources e.g. pci, usb. Deprecated, use 'mapped-resource-info' instead.
     * Type: array
     * Optional: True
     */
    @JsonProperty("mapped-resources")
    private List<String> mappedResources;

    /**
     * List of not allowed nodes with additional information.
     * Type: object
     * Optional: True
     */
    @JsonProperty("not_allowed_nodes")
    private Object notAllowedNodes;

    /**
     * Determines if the VM is running.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("running")
    private Boolean running;


}
