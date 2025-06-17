package io.github.pve.client.model.nodes.certificates.custom;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * Upload or update custom certificate chain and key.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UploadCustomCertResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("filename")
    private String filename;

    /**
     * Certificate SHA 256 fingerprint.
     * Type: string
     * Optional: True
     */
    @JsonProperty("fingerprint")
    private String fingerprint;

    /**
     * Certificate issuer name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("issuer")
    private String issuer;

    /**
     * Certificate's notAfter timestamp (UNIX epoch).
     * Type: integer
     * Optional: True
     */
    @JsonProperty("notafter")
    private Integer notafter;

    /**
     * Certificate's notBefore timestamp (UNIX epoch).
     * Type: integer
     * Optional: True
     */
    @JsonProperty("notbefore")
    private Integer notbefore;

    /**
     * Certificate in PEM format
     * Type: string
     * Optional: True
     */
    @JsonProperty("pem")
    private String pem;

    /**
     * Certificate's public key size
     * Type: integer
     * Optional: True
     */
    @JsonProperty("public-key-bits")
    private Integer publicKeyBits;

    /**
     * Certificate's public key algorithm
     * Type: string
     * Optional: True
     */
    @JsonProperty("public-key-type")
    private String publicKeyType;

    /**
     * List of Certificate's SubjectAlternativeName entries.
     * Type: array
     * Optional: True
     */
    @JsonProperty("san")
    private List<String> san;

    /**
     * Certificate subject name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("subject")
    private String subject;


}
