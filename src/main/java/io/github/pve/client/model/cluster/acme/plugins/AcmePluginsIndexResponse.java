package io.github.pve.client.model.cluster.acme.plugins;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * ACME plugin index.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AcmePluginsIndexResponse {

    /**
     * Unique identifier for ACME plugin instance.
     * Type: string
     * Optional: True
     */
    @JsonProperty("plugin")
    private String plugin;


}
