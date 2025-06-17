package io.github.pve.client.model.nodes.lxc.firewall.ipset;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;

/**
 * Update IP or Network settings
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateIpRequest {

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
     * Optional: True
     */
    @Size(max=64, message="Parameter 'digest' length must not exceed 64")
    @JsonProperty("digest")
    private String digest;

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

    /**
     * Path parameter: cidr
     * Type: string
     * Optional: True
     */
    @JsonProperty("cidr")
    private String cidr;


}
