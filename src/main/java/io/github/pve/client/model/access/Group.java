package io.github.pve.client.model.access;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Proxmox VE 组信息
 * Corresponds to an item in the response from GET /access/groups
 */
@Data
public class Group {
    /**
     * The group ID.
     */
    @JsonProperty("groupid")
    private String groupId;

    /**
     * A comment for the group.
     */
    private String comment;

    /**
     * List of users who are members of this group.
     * Note: This field is only present when querying a specific group (GET /access/groups/{groupid}).
     */
    private List<String> members;
}

