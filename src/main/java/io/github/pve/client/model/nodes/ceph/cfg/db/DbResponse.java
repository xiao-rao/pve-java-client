package io.github.pve.client.model.nodes.ceph.cfg.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Get the Ceph configuration database.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DbResponse {

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("can_update_at_runtime")
    private Boolean canUpdateAtRuntime;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("level")
    private String level;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("mask")
    private String mask;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("section")
    private String section;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("value")
    private String value;


}
