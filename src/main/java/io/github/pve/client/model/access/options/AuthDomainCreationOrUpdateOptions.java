package io.github.pve.client.model.access.options;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pve.client.model.Validatable;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthDomainCreationOrUpdateOptions implements Validatable {

    @NotBlank
    private String realm;
    @NotBlank
    private String type;
    // Common properties
    private String comment;
    @JsonProperty("default")
    private Integer isDefault;
    private String tfa;

    // LDAP / AD specific properties
    private String server1;
    private String server2;
    @JsonProperty("base_dn")
    private String baseDn;
    @JsonProperty("user_attr")
    private String userAttr;
    private Integer port;
    private String protocol;
    private Integer verify;
    @JsonProperty("bind_dn")
    private String bindDn;
    private String password;
    @JsonProperty("group_dn")
    private String groupDn;
    @JsonProperty("group_filter")
    private String groupFilter;
    @JsonProperty("group_name_attr")
    private String groupNameAttr;
    @JsonProperty("user_classes")
    private String userClasses;
    @JsonProperty("user_filter")
    private String userFilter;
    @JsonProperty("sync-defaults-options")
    private String syncDefaultsOptions;
    @JsonProperty("sync_attributes")
    private String syncAttributes;
    private String capath;
    private String cert;
    private String certkey;
    @JsonProperty("check-connection")
    private Boolean checkConnection;
    @JsonProperty("client-principal")
    private String clientPrincipal;
    @JsonProperty("domain-controller")
    private String domainController;
    private String keytab;
    @JsonProperty("group-style")
    private String groupStyle;
    private String mode; // 'ldap' or 'ms-ad'
    private Boolean referrals;
    @JsonProperty("sasl-mech")
    private String saslMech;
    private Boolean secure; // For AD
    private Boolean ssl; // For AD

    // OpenID specific properties
    @JsonProperty("issuer-url")
    private String issuerUrl;
    @JsonProperty("client-id")
    private String clientId;
    @JsonProperty("client-key")
    private String clientKey;
    private Boolean authtime;
    private String scopes;
    @JsonProperty("username-claim")
    private String usernameClaim;
    @JsonProperty("acr-values")
    private String acrValues;
    @JsonProperty("prompt")
    private String prompt;
    @JsonProperty("username-prefix")
    private String usernamePrefix;
    @JsonProperty("username-suffix")
    private String usernameSuffix;
}

