package io.github.pve.client.model.access.ticket;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;

/**
 * Create or verify authentication ticket.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateTicketRequest {

    /**
     * This parameter is now ignored and assumed to be 1.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("new-format")
    private Boolean newFormat;

    /**
     * One-time password for Two-factor authentication.
     * Type: string
     * Optional: True
     */
    @JsonProperty("otp")
    private String otp;

    /**
     * The secret password. This can also be a valid ticket.
     * Type: string
     * Optional: True
     */
    @JsonProperty("password")
    private String password;

    /**
     * Verify ticket, and check if user have access 'privs' on 'path'
     * Type: string
     * Optional: True
     */
    @Size(max=64, message="Parameter 'path' length must not exceed 64")
    @JsonProperty("path")
    private String path;

    /**
     * Verify ticket, and check if user have access 'privs' on 'path'
     * Type: string
     * Optional: True
     */
    @Size(max=64, message="Parameter 'privs' length must not exceed 64")
    @JsonProperty("privs")
    private String privs;

    /**
     * You can optionally pass the realm using this parameter. Normally the realm is simply added to the username <username>@<realm>.
     * Type: string
     * Optional: True
     */
    @Size(max=32, message="Parameter 'realm' length must not exceed 32")
    @JsonProperty("realm")
    private String realm;

    /**
     * The signed TFA challenge string the user wants to respond to.
     * Type: string
     * Optional: True
     */
    @JsonProperty("tfa-challenge")
    private String tfaChallenge;

    /**
     * User name
     * Type: string
     * Optional: True
     */
    @Size(max=64, message="Parameter 'username' length must not exceed 64")
    @JsonProperty("username")
    private String username;


}
