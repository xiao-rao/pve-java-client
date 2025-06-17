package io.github.pve.client.model.cluster.notifications.endpoints.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import java.util.List;
import jakarta.validation.constraints.Size;

/**
 * Update existing webhook endpoint
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateWebhookEndpointRequest {

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
     * A list of settings you want to delete.
     * Type: array
     * Optional: True
     */
    @JsonProperty("delete")
    private List<String> delete;

    /**
     * Prevent changes if current configuration file has a different digest. This can be used to prevent concurrent modifications.
     * Type: string
     * Optional: True
     */
    @Size(max=64, message="Parameter 'digest' length must not exceed 64")
    @JsonProperty("digest")
    private String digest;

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

    /**
     * Path parameter: name
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;


}
