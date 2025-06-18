package io.github.pve.client.model.cluster.acme.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Pattern;

/**
 * Register a new ACME account with CA.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterAccountRequest {

    /**
     * Contact email addresses.
     * Type: string
     * Optional: True
     */
    @JsonProperty("contact")
    private String contact;

    /**
     * URL of ACME CA directory endpoint.
     * Type: string
     * Optional: True
     */
    @Pattern(regexp="^https?://.*", message="Parameter 'directory' does not match pattern")
    @JsonProperty("directory")
    private String directory;

    /**
     * HMAC key for External Account Binding.
     * Type: string
     * Optional: True
     */
    @JsonProperty("eab-hmac-key")
    private String eabHmacKey;

    /**
     * Key Identifier for External Account Binding.
     * Type: string
     * Optional: True
     */
    @JsonProperty("eab-kid")
    private String eabKId;

    /**
     * ACME account config file name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;

    /**
     * URL of CA TermsOfService - setting this indicates agreement.
     * Type: string
     * Optional: True
     */
    @JsonProperty("tos_url")
    private String tosUrl;


}
