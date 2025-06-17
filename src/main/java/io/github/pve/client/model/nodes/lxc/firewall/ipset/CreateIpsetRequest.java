package io.github.pve.client.model.nodes.lxc.firewall.ipset;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

/**
 * Create new IPSet
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateIpsetRequest {

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
     * IP set name.
     * Type: string
     * Optional: True
     */
    @Size(max=64, message="Parameter 'name' length must not exceed 64")
    @Pattern(regexp="[A-Za-z][A-Za-z0-9\\-\\_]+", message="Parameter 'name' does not match pattern")
    @JsonProperty("name")
    private String name;

    /**
     * Rename an existing IPSet. You can set 'rename' to the same value as 'name' to update the 'comment' of an existing IPSet.
     * Type: string
     * Optional: True
     */
    @Size(max=64, message="Parameter 'rename' length must not exceed 64")
    @Pattern(regexp="[A-Za-z][A-Za-z0-9\\-\\_]+", message="Parameter 'rename' does not match pattern")
    @JsonProperty("rename")
    private String rename;


}
