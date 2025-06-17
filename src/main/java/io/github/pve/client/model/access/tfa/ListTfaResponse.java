package io.github.pve.client.model.access.tfa;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * List TFA configurations of users.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListTfaResponse {

    /**
     * 
     * Type: array
     * Optional: True
     */
    @JsonProperty("entries")
    private List<Object> entries;

    /**
     * Contains a timestamp until when a user is locked out of 2nd factors.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("tfa-locked-until")
    private Integer tfaLockedUntil;

    /**
     * True if the user is currently locked out of TOTP factors.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("totp-locked")
    private Boolean totpLocked;

    /**
     * User this entry belongs to.
     * Type: string
     * Optional: True
     */
    @JsonProperty("userid")
    private String userid;


}
