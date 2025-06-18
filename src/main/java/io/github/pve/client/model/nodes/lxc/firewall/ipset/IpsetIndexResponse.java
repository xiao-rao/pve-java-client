package io.github.pve.client.model.nodes.lxc.firewall.ipset;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * List IPSets
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IpsetIndexResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("comment")
    private String comment;

    /**
     * Prevent changes if current configuration file has a different digest. This can be used to prevent concurrent modifications.
     * Type: string
     * Optional: False
     */
    @JsonProperty("digest")
    private String digest;

    /**
     * IP set name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;


}
