package io.github.pve.client.model.cluster.sdn.dns;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotNull;

/**
 * Create a new sdn dns object.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateRequest {

    /**
     * The SDN dns object identifier.
     * Type: string
     * Optional: True
     */
    @JsonProperty("dns")
    private String dns;

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
     * Optional: False
     */
    @NotNull(message = "Parameter 'key' must not be null")
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
    @JsonProperty("reversev6mask")
    private Integer reversev6mask;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("ttl")
    private Integer ttl;

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
     * Optional: False
     */
    @NotNull(message = "Parameter 'url' must not be null")
    @JsonProperty("url")
    private String url;


}
