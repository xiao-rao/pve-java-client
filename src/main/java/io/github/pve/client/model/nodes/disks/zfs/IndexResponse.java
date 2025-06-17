package io.github.pve.client.model.nodes.disks.zfs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * List Zpools.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndexResponse {

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("alloc")
    private Integer alloc;

    /**
     * 
     * Type: number
     * Optional: True
     */
    @JsonProperty("dedup")
    private Double dedup;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("frag")
    private Integer frag;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("free")
    private Integer free;

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
    @JsonProperty("name")
    private String name;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("size")
    private Integer size;


}
