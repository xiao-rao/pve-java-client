package io.github.pve.client.model.access.tfa;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;

/**
 * Add a TFA entry for a user.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateTfaEntryRequest {

    /**
     * A description to distinguish multiple entries from one another
     * Type: string
     * Optional: True
     */
    @Size(max=255, message="Parameter 'description' length must not exceed 255")
    @JsonProperty("description")
    private String description;

    /**
     * Whether the entry should be enabled for login.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("enable")
    private Boolean enable;

    /**
     * The current password of the user performing the change.
     * Type: string
     * Optional: True
     */
    @Size(max=64, message="Parameter 'password' length must not exceed 64")
    @JsonProperty("password")
    private String password;

    /**
     * Path parameter: userid
     * Type: string
     * Optional: True
     */
    @JsonProperty("userid")
    private String userId;

    /**
     * Path parameter: id
     * Type: string
     * Optional: True
     */
    @JsonProperty("id")
    private String id;


}
