package io.github.pve.client.model.access;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 访问控制列表 (ACL) 信息
 * Corresponds to an item in the response from GET /access/acl
 */
@Data
public class Acl {
    /**
     * The path of the resource this ACL applies to.
     */
    private String path;

    /**
     * The user or group ID this ACL applies to.
     * For users: "user@realm", for groups: "@groupid", for API tokens: "user@realm!tokenid"
     */
    private String ugid;

    /**
     * The role ID assigned.
     */
    @JsonProperty("roleid")
    private String roleId;

    /**
     * Whether the permission propagates down the resource tree.
     */
    private Integer propagate;

    /**
     * Type of the subject. Inferred from ugid format ('user', 'group', 'token').
     */
    private String type;
}

