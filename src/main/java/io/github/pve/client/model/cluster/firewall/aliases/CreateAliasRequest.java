package io.github.pve.client.model.cluster.firewall.aliases;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

/**
 * Create IP or Network Alias.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateAliasRequest {

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
     * Alias name.
     * Type: string
     * Optional: True
     */
    @Size(max=64, message="Parameter 'name' length must not exceed 64")
    @Pattern(regexp="[A-Za-z][A-Za-z0-9\\-\\_]+", message="Parameter 'name' does not match pattern")
    @JsonProperty("name")
    private String name;


}
