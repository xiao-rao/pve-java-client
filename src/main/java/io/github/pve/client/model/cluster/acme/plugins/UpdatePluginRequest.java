package io.github.pve.client.model.cluster.acme.plugins;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;

/**
 * Update ACME plugin configuration.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdatePluginRequest {

    /**
     * API plugin name
     * Type: string
     * Optional: True
     */
    @JsonProperty("api")
    private String api;

    /**
     * DNS plugin data. (base64 encoded)
     * Type: string
     * Optional: True
     */
    @JsonProperty("data")
    private String data;

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
     * Flag to disable the config.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("disable")
    private Boolean disable;

    /**
     * List of cluster node names.
     * Type: string
     * Optional: True
     */
    @JsonProperty("nodes")
    private String nodes;

    /**
     * Extra delay in seconds to wait before requesting validation. Allows to cope with a long TTL of DNS records.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("validation-delay")
    private Integer validationDelay;

    /**
     * Path parameter: id
     * Type: string
     * Optional: True
     */
    @JsonProperty("id")
    private String id;


}
