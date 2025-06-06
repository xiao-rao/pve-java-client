package io.github.pve.client.config;


import lombok.Getter;

/**
 * 认证配置
 */
@Getter
public class AuthenticationConfig {

    public enum AuthType {
        API_TOKEN,
        USERNAME_PASSWORD
    }

    private final AuthType authType;
    // Also used for API Token ID
    private final String username; // For USERNAME_PASSWORD or API Token ID (e.g., user@pam!tokenId)
    // Also used for API Token Secret
    private final String password; // For USERNAME_PASSWORD or API Token Secret
    private final String realm;    // For USERNAME_PASSWORD (e.g., "pam", "pve")

    // For API Token
    private AuthenticationConfig(String apiTokenId, String apiTokenSecret) {
        if (apiTokenId == null || apiTokenId.trim().isEmpty() || !apiTokenId.contains("!")) {
            throw new IllegalArgumentException("Invalid API Token ID format. Expected 'user@realm!tokenId'.");
        }
        if (apiTokenSecret == null || apiTokenSecret.trim().isEmpty()) {
            throw new IllegalArgumentException("API Token Secret cannot be null or empty.");
        }
        this.authType = AuthType.API_TOKEN;
        this.username = apiTokenId;
        this.password = apiTokenSecret;
        this.realm = null; // Not used for API token directly in this object
    }

    // For Username/Password
    private AuthenticationConfig(String username, String password, String realm) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty.");
        }
        if (password == null) { // Password can be empty for some auth methods, but usually not
            throw new IllegalArgumentException("Password cannot be null.");
        }
        if (realm == null || realm.trim().isEmpty()) {
            throw new IllegalArgumentException("Realm cannot be null or empty for username/password authentication.");
        }
        this.authType = AuthType.USERNAME_PASSWORD;
        this.username = username;
        this.password = password;
        this.realm = realm;
    }

    public static AuthenticationConfig TlsClientAuthNotUsed() {
        return new AuthenticationConfig("not_used_user@pam!not_used_token", "not_used_secret");
    }

    public static AuthenticationConfig apiToken(String apiTokenId, String apiTokenSecret) {
        return new AuthenticationConfig(apiTokenId, apiTokenSecret);
    }

    public static AuthenticationConfig usernamePassword(String username, String password, String realm) {
        return new AuthenticationConfig(username, password, realm);
    }

    public String getApiTokenHeaderValue() {
        if (authType != AuthType.API_TOKEN) {
            throw new IllegalStateException("Cannot get API token header for non-API_TOKEN auth type.");
        }
        // API Token format: PVEAPIToken=<USER>@<REALM>!<TOKENID>=<UUID>
        return "PVEAPIToken=" + username + "=" + password;
    }

    @Override
    public String toString() {
        return "AuthenticationConfig{" +
                "authType=" + authType +
                ", username='" + (username != null ? username.split("!")[0] + "!***" : "null") + '\'' + // Obfuscate token name part
                // Password/secret should not be in toString
                (realm != null ? ", realm='" + realm + '\'' : "") +
                '}';
    }
}


