package io.github.pve.client.model.cluster.firewall.ipset;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * List IPSet content
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetIpsetResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("cidr")
    private String cidr;

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
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("nomatch")
    private Boolean nomatch;


}
