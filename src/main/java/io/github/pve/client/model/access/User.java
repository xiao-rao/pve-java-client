package io.github.pve.client.model.access;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Proxmox VE 用户信息
 * Corresponds to an item in the response from GET /access/users
 */
@Data
public class User {
    /**
     * The user ID.
     */
    @JsonProperty("userid")
    private String userId;

    /**
     * User's email address.
     */
    private String email;

    /**
     * The user's first name.
     */
    @JsonProperty("firstname")
    private String firstName;

    /**
     * The user's last name.
     */
    @JsonProperty("lastname")
    private String lastName;

    /**
     * Unix timestamp of the user's expiration date. 0 means no expiration.
     */
    private Long expire;

    /**
     * Whether the user is enabled. 1 for enabled, 0 for disabled.
     */
    private Integer enable;

    /**
     * A comment for the user.
     */
    private String comment;
}

