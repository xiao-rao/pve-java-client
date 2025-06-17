package io.github.pve.client.model.nodes.qemu.agent.setuserpassword;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;

/**
 * Sets the password for the given user to the given password
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SetUserPasswordRequest {

    /**
     * set to 1 if the password has already been passed through crypt()
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("crypted")
    private Boolean crypted;

    /**
     * The new password.
     * Type: string
     * Optional: True
     */
    @Size(max=1024, message="Parameter 'password' length must not exceed 1024")
    @JsonProperty("password")
    private String password;

    /**
     * The user to set the password for.
     * Type: string
     * Optional: True
     */
    @JsonProperty("username")
    private String username;


}
