package io.github.pve.client.model.cluster.notifications.endpoints.gotify;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Returns a list of all gotify endpoints
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetGotifyEndpointsResponse {

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
     * Show if this entry was created by a user or was built-in
     * Type: string
     * Optional: True
     */
    @JsonProperty("origin")
    private String origin;

    /**
     * Server URL
     * Type: string
     * Optional: True
     */
    @JsonProperty("server")
    private String server;


}
