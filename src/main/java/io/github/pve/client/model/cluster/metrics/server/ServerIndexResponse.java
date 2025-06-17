package io.github.pve.client.model.cluster.metrics.server;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * List configured metric servers.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerIndexResponse {

    /**
     * Flag to disable the plugin.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("disable")
    private Boolean disable;

    /**
     * The ID of the entry.
     * Type: string
     * Optional: True
     */
    @JsonProperty("id")
    private String id;

    /**
     * Server network port
     * Type: integer
     * Optional: True
     */
    @JsonProperty("port")
    private Integer port;

    /**
     * Server dns name or IP address
     * Type: string
     * Optional: True
     */
    @JsonProperty("server")
    private String server;

    /**
     * Plugin type.
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;


}
