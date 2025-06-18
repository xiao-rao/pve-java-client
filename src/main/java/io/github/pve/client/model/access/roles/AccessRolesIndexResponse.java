package io.github.pve.client.model.access.roles;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Role index.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccessRolesIndexResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("privs")
    private String privs;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("roleid")
    private String roleId;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("special")
    private Boolean special;


}
