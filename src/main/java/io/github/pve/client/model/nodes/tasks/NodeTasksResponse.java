package io.github.pve.client.model.nodes.tasks;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Read task list for one node (finished tasks).
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NodeTasksResponse {

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("endtime")
    private Integer endtime;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("id")
    private String id;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("node")
    private String node;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("pid")
    private Integer pid;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("pstart")
    private Integer pstart;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("starttime")
    private Integer starttime;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("status")
    private String status;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("upid")
    private String upid;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("user")
    private String user;


}
