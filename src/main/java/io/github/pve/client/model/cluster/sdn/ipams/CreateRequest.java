package io.github.pve.client.model.cluster.sdn.ipams;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Pattern;

/**
 * Create a new sdn ipam object.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateRequest {

    /**
     * Certificate SHA 256 fingerprint.
     * Type: string
     * Optional: True
     */
    @Pattern(regexp="([A-Fa-f0-9]{2}:){31}[A-Fa-f0-9]{2}", message="Parameter 'fingerprint' does not match pattern")
    @JsonProperty("fingerprint")
    private String fingerprint;

    /**
     * The SDN ipam object identifier.
     * Type: string
     * Optional: True
     */
    @JsonProperty("ipam")
    private String ipam;

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
     * Plugin type.
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("url")
    private String url;


}
