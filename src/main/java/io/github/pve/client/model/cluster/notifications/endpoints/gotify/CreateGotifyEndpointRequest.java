package io.github.pve.client.model.cluster.notifications.endpoints.gotify;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Create a new gotify endpoint
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateGotifyEndpointRequest {

    /**
     * Comment
     * Type: string
     * Optional: True
     */
    @JsonProperty("comment")
    private String comment;

    /**
     * Disable this target
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("disable")
    private Boolean disable;

    /**
     * The name of the endpoint.
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;

    /**
     * Server URL
     * Type: string
     * Optional: True
     */
    @JsonProperty("server")
    private String server;

    /**
     * Secret token
     * Type: string
     * Optional: True
     */
    @JsonProperty("token")
    private String token;


}
