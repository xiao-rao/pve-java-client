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
public class AddTfaEntryRequest {

    /**
     * When responding to a u2f challenge: the original challenge string
     * Type: string
     * Optional: True
     */
    @JsonProperty("challenge")
    private String challenge;

    /**
     * A description to distinguish multiple entries from one another
     * Type: string
     * Optional: True
     */
    @Size(max=255, message="Parameter 'description' length must not exceed 255")
    @JsonProperty("description")
    private String description;

    /**
     * The current password of the user performing the change.
     * Type: string
     * Optional: True
     */
    @Size(max=64, message="Parameter 'password' length must not exceed 64")
    @JsonProperty("password")
    private String password;

    /**
     * A totp URI.
     * Type: string
     * Optional: True
     */
    @JsonProperty("totp")
    private String totp;

    /**
     * TFA Entry Type.
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;

    /**
     * The current value for the provided totp URI, or a Webauthn/U2F challenge response
     * Type: string
     * Optional: True
     */
    @JsonProperty("value")
    private String value;

    /**
     * Path parameter: userid
     * Type: string
     * Optional: True
     */
    @JsonProperty("userid")
    private String userId;


}
