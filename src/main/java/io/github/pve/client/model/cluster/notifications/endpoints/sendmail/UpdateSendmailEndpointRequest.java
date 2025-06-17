package io.github.pve.client.model.cluster.notifications.endpoints.sendmail;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import java.util.List;
import jakarta.validation.constraints.Size;

/**
 * Update existing sendmail endpoint
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateSendmailEndpointRequest {

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
     * Path parameter: name
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;


}
