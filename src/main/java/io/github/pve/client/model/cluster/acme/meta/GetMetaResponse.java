package io.github.pve.client.model.cluster.acme.meta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * Retrieve ACME Directory Meta Information
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetMetaResponse {

    /**
     * Hostnames referring to the ACME servers.
     * Type: array
     * Optional: True
     */
    @JsonProperty("caaIdentities")
    private List<String> caaidentities;

    /**
     * EAB Required
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("externalAccountRequired")
    private Boolean externalaccountrequired;

    /**
     * ACME TermsOfService URL.
     * Type: string
     * Optional: True
     */
    @JsonProperty("termsOfService")
    private String termsofservice;

    /**
     * URL to more information about the ACME server.
     * Type: string
     * Optional: True
     */
    @JsonProperty("website")
    private String website;


}
