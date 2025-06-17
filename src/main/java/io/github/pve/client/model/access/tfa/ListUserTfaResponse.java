package io.github.pve.client.model.access.tfa;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * List TFA configurations of users.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListUserTfaResponse {

    /**
     * Creation time of this entry as unix epoch.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("created")
    private Integer created;

    /**
     * User chosen description for this entry.
     * Type: string
     * Optional: True
     */
    @JsonProperty("description")
    private String description;

    /**
     * Whether this TFA entry is currently enabled.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("enable")
    private Boolean enable;

    /**
     * The id used to reference this entry.
     * Type: string
     * Optional: True
     */
    @JsonProperty("id")
    private String id;

    /**
     * TFA Entry Type.
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;


}
