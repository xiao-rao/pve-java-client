package io.github.pve.client.model.cluster.notifications.endpoints.smtp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import java.util.List;
import jakarta.validation.constraints.Size;

/**
 * Update existing smtp endpoint
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateSmtpEndpointRequest {

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
     * Password for SMTP authentication
     * Type: string
     * Optional: True
     */
    @JsonProperty("password")
    private String password;

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

    /**
     * Path parameter: name
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;


}
