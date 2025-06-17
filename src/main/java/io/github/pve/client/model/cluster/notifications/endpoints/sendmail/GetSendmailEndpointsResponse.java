package io.github.pve.client.model.cluster.notifications.endpoints.sendmail;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * Returns a list of all sendmail endpoints
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetSendmailEndpointsResponse {

    /**
     * Author of the mail
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


}
