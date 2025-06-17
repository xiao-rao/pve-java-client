package io.github.pve.client.model.cluster.firewall.ipset;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Add IP or Network to IPSet.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateIpRequest {

    /**
     * Network/IP specification in CIDR format.
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
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("nomatch")
    private Boolean nomatch;

    /**
     * Path parameter: name
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;


}
