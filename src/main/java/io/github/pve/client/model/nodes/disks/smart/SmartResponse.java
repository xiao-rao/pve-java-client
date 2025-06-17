package io.github.pve.client.model.nodes.disks.smart;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * Get SMART Health of a disk.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SmartResponse {

    /**
     * 
     * Type: array
     * Optional: True
     */
    @JsonProperty("attributes")
    private List<Object> attributes;

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
    @JsonProperty("text")
    private String text;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;


}
