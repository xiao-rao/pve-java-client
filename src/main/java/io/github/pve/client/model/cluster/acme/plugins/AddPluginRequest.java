package io.github.pve.client.model.cluster.acme.plugins;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Add ACME plugin configuration.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddPluginRequest {

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
     * Flag to disable the config.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("disable")
    private Boolean disable;

    /**
     * ACME Plugin ID name
     * Type: string
     * Optional: True
     */
    @JsonProperty("id")
    private String id;

    /**
     * List of cluster node names.
     * Type: string
     * Optional: True
     */
    @JsonProperty("nodes")
    private String nodes;

    /**
     * ACME challenge type.
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;

    /**
     * Extra delay in seconds to wait before requesting validation. Allows to cope with a long TTL of DNS records.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("validation-delay")
    private Integer validationDelay;


}
