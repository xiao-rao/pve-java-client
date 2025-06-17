package io.github.pve.client.model.cluster.notifications.targets;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Returns a list of all entities that can be used as notification targets.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetAllTargetsResponse {

    /**
     * Comment
     * Type: string
     * Optional: True
     */
    @JsonProperty("comment")
    private String comment;

    /**
     * Show if this target is disabled
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("disable")
    private Boolean disable;

    /**
     * Name of the target.
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;

    /**
     * Show if this entry was created by a user or was built-in
     * Type: string
     * Optional: True
     */
    @JsonProperty("origin")
    private String origin;

    /**
     * Type of the target.
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;


}
