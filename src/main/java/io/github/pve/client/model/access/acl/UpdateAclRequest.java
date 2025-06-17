package io.github.pve.client.model.access.acl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Update Access Control List (add or remove permissions).
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateAclRequest {

    /**
     * Remove permissions (instead of adding it).
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("delete")
    private Boolean delete;

    /**
     * List of groups.
     * Type: string
     * Optional: True
     */
    @JsonProperty("groups")
    private String groups;

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
     * List of roles.
     * Type: string
     * Optional: True
     */
    @JsonProperty("roles")
    private String roles;

    /**
     * List of API tokens.
     * Type: string
     * Optional: True
     */
    @JsonProperty("tokens")
    private String tokens;

    /**
     * List of users.
     * Type: string
     * Optional: True
     */
    @JsonProperty("users")
    private String users;


}
