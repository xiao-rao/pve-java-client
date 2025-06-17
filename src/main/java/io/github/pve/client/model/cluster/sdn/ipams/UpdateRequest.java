package io.github.pve.client.model.cluster.sdn.ipams;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

/**
 * Update sdn ipam object configuration.
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
     * Type: integer
     * Optional: True
     */
    @JsonProperty("section")
    private Integer section;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("token")
    private String token;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("url")
    private String url;

    /**
     * Path parameter: ipam
     * Type: string
     * Optional: True
     */
    @JsonProperty("ipam")
    private String ipam;


}
