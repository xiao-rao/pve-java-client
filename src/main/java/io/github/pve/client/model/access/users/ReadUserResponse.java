package io.github.pve.client.model.access.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Get user configuration.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReadUserResponse {

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
     * Type: array
     * Optional: True
     */
    @JsonProperty("groups")
    private List<String> groups;

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
     * 
     * Type: object
     * Optional: True
     */
    @JsonProperty("tokens")
    private Map<String, Object> tokens;


}
