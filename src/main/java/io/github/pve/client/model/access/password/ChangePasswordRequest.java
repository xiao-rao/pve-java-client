package io.github.pve.client.model.access.password;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;

/**
 * Change user password.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChangePasswordRequest {

    /**
     * The current password of the user performing the change.
     * Type: string
     * Optional: True
     */
    @Size(max=64, message="Parameter 'confirmation-password' length must not exceed 64")
    @JsonProperty("confirmation-password")
    private String confirmationPassword;

    /**
     * The new password.
     * Type: string
     * Optional: True
     */
    @Size(max=64, message="Parameter 'password' length must not exceed 64")
    @JsonProperty("password")
    private String password;

    /**
     * Full User ID, in the `name@realm` format.
     * Type: string
     * Optional: True
     */
    @Size(max=64, message="Parameter 'userid' length must not exceed 64")
    @JsonProperty("userid")
    private String userid;


}
