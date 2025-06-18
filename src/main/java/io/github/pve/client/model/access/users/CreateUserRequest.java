package io.github.pve.client.model.access.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

/**
 * Create new user.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUserRequest {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @Size(max=2048, message="Parameter 'comment' length must not exceed 2048")
    @JsonProperty("comment")
    private String comment;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @Size(max=254, message="Parameter 'email' length must not exceed 254")
    @JsonProperty("email")
    private String email;

    /**
     * Enable the account (default). You can set this to '0' to disable the account
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("enable")
    private Boolean enable;

    /**
     * Account expiration date (seconds since epoch). '0' means no expiration date.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("expire")
    private Integer expire;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @Size(max=1024, message="Parameter 'firstname' length must not exceed 1024")
    @JsonProperty("firstname")
    private String firstname;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("groups")
    private String groups;

    /**
     * Keys for two factor auth (yubico).
     * Type: string
     * Optional: True
     */
    @Pattern(regexp="[0-9a-zA-Z!=]{0,4096}", message="Parameter 'keys' does not match pattern")
    @JsonProperty("keys")
    private String keys;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @Size(max=1024, message="Parameter 'lastname' length must not exceed 1024")
    @JsonProperty("lastname")
    private String lastname;

    /**
     * Initial password.
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
    private String userId;


}
