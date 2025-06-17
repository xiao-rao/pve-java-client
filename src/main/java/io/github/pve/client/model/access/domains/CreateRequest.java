package io.github.pve.client.model.access.domains;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

/**
 * Add an authentication server.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateRequest {

    /**
     * Specifies the Authentication Context Class Reference values that theAuthorization Server is being requested to use for the Auth Request.
     * Type: string
     * Optional: True
     */
    @Pattern(regexp="^[^\\x00-\\x1F\\x7F <>#\"]*$", message="Parameter 'acr-values' does not match pattern")
    @JsonProperty("acr-values")
    private String acrValues;

    /**
     * Automatically create users if they do not exist.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("autocreate")
    private Boolean autocreate;

    /**
     * LDAP base domain name
     * Type: string
     * Optional: True
     */
    @Size(max=256, message="Parameter 'base_dn' length must not exceed 256")
    @JsonProperty("base_dn")
    private String baseDn;

    /**
     * LDAP bind domain name
     * Type: string
     * Optional: True
     */
    @Size(max=256, message="Parameter 'bind_dn' length must not exceed 256")
    @JsonProperty("bind_dn")
    private String bindDn;

    /**
     * Path to the CA certificate store
     * Type: string
     * Optional: True
     */
    @JsonProperty("capath")
    private String capath;

    /**
     * username is case-sensitive
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("case-sensitive")
    private Boolean caseSensitive;

    /**
     * Path to the client certificate
     * Type: string
     * Optional: True
     */
    @JsonProperty("cert")
    private String cert;

    /**
     * Path to the client certificate key
     * Type: string
     * Optional: True
     */
    @JsonProperty("certkey")
    private String certkey;

    /**
     * Check bind connection to the server.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("check-connection")
    private Boolean checkConnection;

    /**
     * OpenID Client ID
     * Type: string
     * Optional: True
     */
    @Size(max=256, message="Parameter 'client-id' length must not exceed 256")
    @JsonProperty("client-id")
    private String clientId;

    /**
     * OpenID Client Key
     * Type: string
     * Optional: True
     */
    @Size(max=256, message="Parameter 'client-key' length must not exceed 256")
    @JsonProperty("client-key")
    private String clientKey;

    /**
     * Description.
     * Type: string
     * Optional: True
     */
    @Size(max=4096, message="Parameter 'comment' length must not exceed 4096")
    @JsonProperty("comment")
    private String comment;

    /**
     * Use this as default realm
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("default")
    private Boolean defaultValue;

    /**
     * AD domain name
     * Type: string
     * Optional: True
     */
    @Size(max=256, message="Parameter 'domain' length must not exceed 256")
    @Pattern(regexp="\\S+", message="Parameter 'domain' does not match pattern")
    @JsonProperty("domain")
    private String domain;

    /**
     * LDAP filter for user sync.
     * Type: string
     * Optional: True
     */
    @Size(max=2048, message="Parameter 'filter' length must not exceed 2048")
    @JsonProperty("filter")
    private String filter;

    /**
     * The objectclasses for groups.
     * Type: string
     * Optional: True
     */
    @JsonProperty("group_classes")
    private String groupClasses;

    /**
     * LDAP base domain name for group sync. If not set, the base_dn will be used.
     * Type: string
     * Optional: True
     */
    @Size(max=256, message="Parameter 'group_dn' length must not exceed 256")
    @JsonProperty("group_dn")
    private String groupDn;

    /**
     * LDAP filter for group sync.
     * Type: string
     * Optional: True
     */
    @Size(max=2048, message="Parameter 'group_filter' length must not exceed 2048")
    @JsonProperty("group_filter")
    private String groupFilter;

    /**
     * LDAP attribute representing a groups name. If not set or found, the first value of the DN will be used as name.
     * Type: string
     * Optional: True
     */
    @Size(max=256, message="Parameter 'group_name_attr' length must not exceed 256")
    @JsonProperty("group_name_attr")
    private String groupNameAttr;

    /**
     * Automatically create groups if they do not exist.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("groups-autocreate")
    private Boolean groupsAutocreate;

    /**
     * OpenID claim used to retrieve groups with.
     * Type: string
     * Optional: True
     */
    @Size(max=256, message="Parameter 'groups-claim' length must not exceed 256")
    @Pattern(regexp="(?^:[A-Za-z0-9\\.\\-_]+)", message="Parameter 'groups-claim' does not match pattern")
    @JsonProperty("groups-claim")
    private String groupsClaim;

    /**
     * All groups will be overwritten for the user on login.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("groups-overwrite")
    private Boolean groupsOverwrite;

    /**
     * OpenID Issuer Url
     * Type: string
     * Optional: True
     */
    @Size(max=256, message="Parameter 'issuer-url' length must not exceed 256")
    @JsonProperty("issuer-url")
    private String issuerUrl;

    /**
     * LDAP protocol mode.
     * Type: string
     * Optional: True
     */
    @JsonProperty("mode")
    private String mode;

    /**
     * LDAP bind password. Will be stored in '/etc/pve/priv/realm/<REALM>.pw'.
     * Type: string
     * Optional: True
     */
    @JsonProperty("password")
    private String password;

    /**
     * Server port.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("port")
    private Integer port;

    /**
     * Specifies whether the Authorization Server prompts the End-User for reauthentication and consent.
     * Type: string
     * Optional: True
     */
    @Pattern(regexp="(?:none|login|consent|select_account|\\S+)", message="Parameter 'prompt' does not match pattern")
    @JsonProperty("prompt")
    private String prompt;

    /**
     * Enables querying the userinfo endpoint for claims values.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("query-userinfo")
    private Boolean queryUserinfo;

    /**
     * Authentication domain ID
     * Type: string
     * Optional: True
     */
    @Size(max=32, message="Parameter 'realm' length must not exceed 32")
    @JsonProperty("realm")
    private String realm;

    /**
     * Specifies the scopes (user details) that should be authorized and returned, for example 'email' or 'profile'.
     * Type: string
     * Optional: True
     */
    @JsonProperty("scopes")
    private String scopes;

    /**
     * Use secure LDAPS protocol. DEPRECATED: use 'mode' instead.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("secure")
    private Boolean secure;

    /**
     * Server IP address (or DNS name)
     * Type: string
     * Optional: True
     */
    @Size(max=256, message="Parameter 'server1' length must not exceed 256")
    @JsonProperty("server1")
    private String server1;

    /**
     * Fallback Server IP address (or DNS name)
     * Type: string
     * Optional: True
     */
    @Size(max=256, message="Parameter 'server2' length must not exceed 256")
    @JsonProperty("server2")
    private String server2;

    /**
     * LDAPS TLS/SSL version. It's not recommended to use version older than 1.2!
     * Type: string
     * Optional: True
     */
    @JsonProperty("sslversion")
    private String sslversion;

    /**
     * The default options for behavior of synchronizations.
     * Type: string
     * Optional: True
     */
    @JsonProperty("sync-defaults-options")
    private String syncDefaultsOptions;

    /**
     * Comma separated list of key=value pairs for specifying which LDAP attributes map to which PVE user field. For example, to map the LDAP attribute 'mail' to PVEs 'email', write  'email=mail'. By default, each PVE user field is represented  by an LDAP attribute of the same name.
     * Type: string
     * Optional: True
     */
    @Pattern(regexp="\\w+=[^,]+(,\\s*\\w+=[^,]+)*", message="Parameter 'sync_attributes' does not match pattern")
    @JsonProperty("sync_attributes")
    private String syncAttributes;

    /**
     * Use Two-factor authentication.
     * Type: string
     * Optional: True
     */
    @Size(max=128, message="Parameter 'tfa' length must not exceed 128")
    @JsonProperty("tfa")
    private String tfa;

    /**
     * Realm type.
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;

    /**
     * LDAP user attribute name
     * Type: string
     * Optional: True
     */
    @Size(max=256, message="Parameter 'user_attr' length must not exceed 256")
    @Pattern(regexp="\\S{2,}", message="Parameter 'user_attr' does not match pattern")
    @JsonProperty("user_attr")
    private String userAttr;

    /**
     * The objectclasses for users.
     * Type: string
     * Optional: True
     */
    @JsonProperty("user_classes")
    private String userClasses;

    /**
     * OpenID claim used to generate the unique username.
     * Type: string
     * Optional: True
     */
    @JsonProperty("username-claim")
    private String usernameClaim;

    /**
     * Verify the server's SSL certificate
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("verify")
    private Boolean verify;


}
