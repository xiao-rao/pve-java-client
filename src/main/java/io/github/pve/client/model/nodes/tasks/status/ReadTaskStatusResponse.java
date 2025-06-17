package io.github.pve.client.model.nodes.tasks.status;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Read task status.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReadTaskStatusResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("exitstatus")
    private String exitstatus;

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
