package io.github.pve.client.model.cluster.status;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Get cluster status information.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetStatusResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("id")
    private String id;

    /**
     * [node] IP of the resolved nodename.
     * Type: string
     * Optional: True
     */
    @JsonProperty("ip")
    private String ip;

    /**
     * [node] Proxmox VE Subscription level, indicates if eligible for enterprise support as well as access to the stable Proxmox VE Enterprise Repository.
     * Type: string
     * Optional: True
     */
    @JsonProperty("level")
    private String level;

    /**
     * [node] Indicates if this is the responding node.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("local")
    private Boolean local;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;

    /**
     * [node] ID of the node from the corosync configuration.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("nodeid")
    private Integer nodeid;

    /**
     * [cluster] Nodes count, including offline nodes.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("nodes")
    private Integer nodes;

    /**
     * [node] Indicates if the node is online or offline.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("online")
    private Boolean online;

    /**
     * [cluster] Indicates if there is a majority of nodes online to make decisions
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("quorate")
    private Boolean quorate;

    /**
     * Indicates the type, either cluster or node. The type defines the object properties e.g. quorate available for type cluster.
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;

    /**
     * [cluster] Current version of the corosync configuration file.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("version")
    private Integer version;


}
