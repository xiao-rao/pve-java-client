package io.github.pve.client.model.cluster.firewall.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * List security groups.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListSecurityGroupsResponse {

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
     * Optional: False
     */
    @JsonProperty("digest")
    private String digest;

    /**
     * Security Group name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("group")
    private String group;


}
