package io.github.pve.client.model.access.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * User index.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndexResponse {

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
    @JsonProperty("keys")
    private String keys;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("lastname")
    private String lastname;

    /**
     * The type of the users realm
     * Type: string
     * Optional: True
     */
    @JsonProperty("realm-type")
    private String realmType;

    /**
     * Contains a timestamp until when a user is locked out of 2nd factors.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("tfa-locked-until")
    private Integer tfaLockedUntil;

    /**
     * 
     * Type: array
     * Optional: True
     */
    @JsonProperty("tokens")
    private List<Object> tokens;

    /**
     * True if the user is currently locked out of TOTP factors.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("totp-locked")
    private Boolean totpLocked;

    /**
     * Full User ID, in the `name@realm` format.
     * Type: string
     * Optional: True
     */
    @JsonProperty("userid")
    private String userid;


}
