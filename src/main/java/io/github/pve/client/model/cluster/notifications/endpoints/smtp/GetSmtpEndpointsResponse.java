package io.github.pve.client.model.cluster.notifications.endpoints.smtp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * Returns a list of all smtp endpoints
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetSmtpEndpointsResponse {

    /**
     * Author of the mail. Defaults to 'Proxmox VE'.
     * Type: string
     * Optional: True
     */
    @JsonProperty("author")
    private String author;

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
     * `From` address for the mail
     * Type: string
     * Optional: True
     */
    @JsonProperty("from-address")
    private String fromAddress;

    /**
     * List of email recipients
     * Type: array
     * Optional: True
     */
    @JsonProperty("mailto")
    private List<String> mailto;

    /**
     * List of users
     * Type: array
     * Optional: True
     */
    @JsonProperty("mailto-user")
    private List<String> mailtoUser;

    /**
     * Determine which encryption method shall be used for the connection.
     * Type: string
     * Optional: True
     */
    @JsonProperty("mode")
    private String mode;

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
     * The port to be used. Defaults to 465 for TLS based connections, 587 for STARTTLS based connections and port 25 for insecure plain-text connections.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("port")
    private Integer port;

    /**
     * The address of the SMTP server.
     * Type: string
     * Optional: True
     */
    @JsonProperty("server")
    private String server;

    /**
     * Username for SMTP authentication
     * Type: string
     * Optional: True
     */
    @JsonProperty("username")
    private String username;


}
