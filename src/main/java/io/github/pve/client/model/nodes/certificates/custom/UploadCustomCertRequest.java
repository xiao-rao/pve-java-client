package io.github.pve.client.model.nodes.certificates.custom;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Upload or update custom certificate chain and key.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UploadCustomCertRequest {

    /**
     * PEM encoded certificate (chain).
     * Type: string
     * Optional: True
     */
    @JsonProperty("certificates")
    private String certificates;

    /**
     * Overwrite existing custom or ACME certificate files.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("force")
    private Boolean force;

    /**
     * PEM encoded private key.
     * Type: string
     * Optional: True
     */
    @JsonProperty("key")
    private String key;

    /**
     * Restart pveproxy.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("restart")
    private Boolean restart;


}
