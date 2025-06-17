package io.github.pve.client.model.cluster.ha.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

/**
 * Create a new HA group.
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
     * List of cluster node names with optional priority.
     * Type: string
     * Optional: False
     */
    @NotNull(message = "Parameter 'nodes' must not be null")
    @JsonProperty("nodes")
    private String nodes;

    /**
     * The CRM tries to run services on the node with the highest priority. If a node with higher priority comes online, the CRM migrates the service to that node. Enabling nofailback prevents that behavior.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("nofailback")
    private Boolean nofailback;

    /**
     * Resources bound to restricted groups may only run on nodes defined by the group.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("restricted")
    private Boolean restricted;

    /**
     * Group type.
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;


}
