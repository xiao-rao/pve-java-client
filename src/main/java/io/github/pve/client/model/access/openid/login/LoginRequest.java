package io.github.pve.client.model.access.openid.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;

/**
 *  Verify OpenID authorization code and create a ticket.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginRequest {

    /**
     * OpenId authorization code.
     * Type: string
     * Optional: True
     */
    @Size(max=4096, message="Parameter 'code' length must not exceed 4096")
    @JsonProperty("code")
    private String code;

    /**
     * Redirection Url. The client should set this to the used server url (location.origin).
     * Type: string
     * Optional: True
     */
    @Size(max=255, message="Parameter 'redirect-url' length must not exceed 255")
    @JsonProperty("redirect-url")
    private String redirectUrl;

    /**
     * OpenId state.
     * Type: string
     * Optional: True
     */
    @Size(max=1024, message="Parameter 'state' length must not exceed 1024")
    @JsonProperty("state")
    private String state;


}
