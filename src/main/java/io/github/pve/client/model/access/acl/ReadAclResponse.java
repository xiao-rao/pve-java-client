package io.github.pve.client.model.access.acl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Get Access Control List (ACLs).
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReadAclResponse {

    /**
     * Access control path
     * Type: string
     * Optional: True
     */
    @JsonProperty("path")
    private String path;

    /**
     * Allow to propagate (inherit) permissions.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("propagate")
    private Boolean propagate;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("roleid")
    private String roleId;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("ugid")
    private String ugId;


}
