package io.github.pve.client.auth;

import lombok.Getter;
import lombok.ToString;

/**
 * 认证成功后返回的凭据详情
 */
@Getter
@ToString
public class AuthenticationDetails {

    private final String ticket; // PVEAuthCookie value
    private final String csrfToken; // CSRFPreventionToken
    private final String username; // The username associated with this authentication

    public AuthenticationDetails(String ticket, String csrfToken, String username) {
        if (csrfToken == null || csrfToken.trim().isEmpty()) {
            throw new IllegalArgumentException("CSRF token cannot be null or empty in AuthenticationDetails.");
        }

        if (ticket == null || ticket.trim().isEmpty()) {
            throw new IllegalArgumentException("ticket cannot be null or empty in AuthenticationDetails.");
        }

        this.ticket = ticket;
        this.csrfToken = csrfToken;
        this.username = username;
    }

}
