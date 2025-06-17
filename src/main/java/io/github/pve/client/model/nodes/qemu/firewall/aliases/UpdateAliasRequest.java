package io.github.pve.client.model.nodes.qemu.firewall.aliases;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

/**
 * Update IP or Network alias.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateAliasRequest {

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
     * Prevent changes if current configuration file has a different digest. This can be used to prevent concurrent modifications.
     * Type: string
     * Optional: True
     */
    @Size(max=64, message="Parameter 'digest' length must not exceed 64")
    @JsonProperty("digest")
    private String digest;

    /**
     * Rename an existing alias.
     * Type: string
     * Optional: True
     */
    @Size(max=64, message="Parameter 'rename' length must not exceed 64")
    @Pattern(regexp="[A-Za-z][A-Za-z0-9\\-\\_]+", message="Parameter 'rename' does not match pattern")
    @JsonProperty("rename")
    private String rename;

    /**
     * Path parameter: name
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;


}
