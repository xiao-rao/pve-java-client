package io.github.pve.client.model.cluster.ha.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Read resource configuration.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReadResponse {

    /**
     * Description.
     * Type: string
     * Optional: True
     */
    @JsonProperty("comment")
    private String comment;

    /**
     * Can be used to prevent concurrent modifications.
     * Type: string
     * Optional: True
     */
    @JsonProperty("digest")
    private String digest;

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
    private String sid;

    /**
     * Requested resource state.
     * Type: string
     * Optional: True
     */
    @JsonProperty("state")
    private String state;

    /**
     * The type of the resources.
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;


}
