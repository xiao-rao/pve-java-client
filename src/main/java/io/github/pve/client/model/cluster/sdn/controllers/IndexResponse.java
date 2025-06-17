package io.github.pve.client.model.cluster.sdn.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * SDN controllers index.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndexResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("controller")
    private String controller;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("pending")
    private Boolean pending;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("state")
    private String state;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;


}
