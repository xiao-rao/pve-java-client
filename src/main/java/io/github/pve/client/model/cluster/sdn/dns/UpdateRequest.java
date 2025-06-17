package io.github.pve.client.model.cluster.sdn.dns;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

/**
 * Update sdn dns object configuration.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateRequest {

    /**
     * A list of settings you want to delete.
     * Type: string
     * Optional: True
     */
    @Size(max=4096, message="Parameter 'delete' length must not exceed 4096")
    @JsonProperty("delete")
    private String delete;

    /**
     * Prevent changes if current configuration file has a different digest. This can be used to prevent concurrent modifications.
     * Type: string
     * Optional: True
     */
    @Size(max=64, message="Parameter 'digest' length must not exceed 64")
    @JsonProperty("digest")
    private String digest;

    /**
     * Certificate SHA 256 fingerprint.
     * Type: string
     * Optional: True
     */
    @Pattern(regexp="([A-Fa-f0-9]{2}:){31}[A-Fa-f0-9]{2}", message="Parameter 'fingerprint' does not match pattern")
    @JsonProperty("fingerprint")
    private String fingerprint;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("key")
    private String key;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("reversemaskv6")
    private Integer reversemaskv6;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("ttl")
    private Integer ttl;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("url")
    private String url;

    /**
     * Path parameter: dns
     * Type: string
     * Optional: True
     */
    @JsonProperty("dns")
    private String dns;


}
