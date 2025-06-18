package io.github.pve.client.model.access.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Group index.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccessGroupsIndexResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("comment")
    private String comment;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("groupid")
    private String groupId;

    /**
     * list of users which form this group
     * Type: string
     * Optional: True
     */
    @JsonProperty("users")
    private String users;


}
