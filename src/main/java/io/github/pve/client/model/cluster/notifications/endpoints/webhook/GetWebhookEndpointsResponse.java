package io.github.pve.client.model.cluster.notifications.endpoints.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * Returns a list of all webhook endpoints
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetWebhookEndpointsResponse {

    /**
     * HTTP body, base64 encoded
     * Type: string
     * Optional: True
     */
    @JsonProperty("body")
    private String body;

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
     * HTTP headers to set. These have to be formatted as a property string in the format name=<name>,value=<base64 of value>
     * Type: array
     * Optional: True
     */
    @JsonProperty("header")
    private List<String> header;

    /**
     * HTTP method
     * Type: string
     * Optional: True
     */
    @JsonProperty("method")
    private String method;

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
     * Secrets to set. These have to be formatted as a property string in the format name=<name>,value=<base64 of value>
     * Type: array
     * Optional: True
     */
    @JsonProperty("secret")
    private List<String> secret;

    /**
     * Server URL
     * Type: string
     * Optional: True
     */
    @JsonProperty("url")
    private String url;


}
