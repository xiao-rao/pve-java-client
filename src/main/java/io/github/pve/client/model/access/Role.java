package io.github.pve.client.model.access;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Proxmox VE 角色信息
 * Corresponds to an item in the response from GET /access/roles
 */
@Data
public class Role {
    /**
     * The role ID.
     */
    @JsonProperty("roleid")
    private String roleId;

    /**
     * A map of privileges associated with the role. The key is the privilege name, value is 1.
     * Note: PVE API returns this as "privs", a string of comma-separated privileges when listing roles.
     * When getting a specific role, it's a map. This model assumes the map structure for detail view.
     * The list view will need custom deserialization if handled by this model.
     */
    private String privs; // For GET /access/roles (list view)

    /**
     * Special role, only for internal use.
     */
    private Integer special;
}

