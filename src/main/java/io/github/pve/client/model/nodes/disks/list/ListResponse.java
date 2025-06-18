package io.github.pve.client.model.nodes.disks.list;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * List local disks.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListResponse {

    /**
     * The device path
     * Type: string
     * Optional: True
     */
    @JsonProperty("devpath")
    private String devpath;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("gpt")
    private Boolean gpt;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("health")
    private String health;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("model")
    private String model;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("mounted")
    private Boolean mounted;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("osdid")
    private Integer osdId;

    /**
     * 
     * Type: array
     * Optional: True
     */
    @JsonProperty("osdid-list")
    private List<Integer> osdIdList;

    /**
     * For partitions only. The device path of the disk the partition resides on.
     * Type: string
     * Optional: True
     */
    @JsonProperty("parent")
    private String parent;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("serial")
    private String serial;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("size")
    private Integer size;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("used")
    private String used;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("vendor")
    private String vendor;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("wwn")
    private String wwn;


}
