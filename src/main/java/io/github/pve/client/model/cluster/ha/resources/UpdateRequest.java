package io.github.pve.client.model.cluster.ha.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;

/**
 * Update resource configuration.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateRequest {

    /**
     * Description.
     * Type: string
     * Optional: True
     */
    @Size(max=4096, message="Parameter 'comment' length must not exceed 4096")
    @JsonProperty("comment")
    private String comment;

    /**
     * A list of settings you want to delete.
     * Type: string
     * Optional: True
     */
    @Size(max=4096, message="Parameter 'delete' length must not exceed 4096")
    @JsonProperty("delete")
    private String delete;

    /**
     * Prevent changes if current configuration file has a different digest. This can be used to prevent concurrent modifications.
     * Type: string
     * Optional: True
     */
    @Size(max=64, message="Parameter 'digest' length must not exceed 64")
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
     * Requested resource state.
     * Type: string
     * Optional: True
     */
    @JsonProperty("state")
    private String state;

    /**
     * Path parameter: sid
     * Type: string
     * Optional: True
     */
    @JsonProperty("sid")
    private String sid;


}
