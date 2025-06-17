package io.github.pve.client.model.nodes.lxc.firewall.refs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Lists possible IPSet/Alias reference which are allowed in source/dest properties.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RefsResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("comment")
    private String comment;

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
    @JsonProperty("ref")
    private String ref;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("scope")
    private String scope;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;


}
