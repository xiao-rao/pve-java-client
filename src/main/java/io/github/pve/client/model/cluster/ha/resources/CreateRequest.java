package io.github.pve.client.model.cluster.ha.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;

/**
 * Create a new HA resource.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateRequest {

    /**
     * Description.
     * Type: string
     * Optional: True
     */
    @Size(max=4096, message="Parameter 'comment' length must not exceed 4096")
    @JsonProperty("comment")
    private String comment;

    /**
     * The HA group identifier.
     * Type: string
     * Optional: True
     */
    @JsonProperty("group")
    private String group;

    /**
     * Maximal number of service relocate tries when a service failes to start.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("max_relocate")
    private Integer maxRelocate;

    /**
     * Maximal number of tries to restart the service on a node after its start failed.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("max_restart")
    private Integer maxRestart;

    /**
     * HA resource ID. This consists of a resource type followed by a resource specific name, separated with colon (example: vm:100 / ct:100). For virtual machines and containers, you can simply use the VM or CT id as a shortcut (example: 100).
     * Type: string
     * Optional: True
     */
    @JsonProperty("sid")
    private String sId;

    /**
     * Requested resource state.
     * Type: string
     * Optional: True
     */
    @JsonProperty("state")
    private String state;

    /**
     * Resource type.
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;


}
