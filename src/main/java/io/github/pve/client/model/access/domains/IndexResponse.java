package io.github.pve.client.model.access.domains;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Authentication domain index.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndexResponse {

    /**
     * A comment. The GUI use this text when you select a domain (Realm) on the login window.
     * Type: string
     * Optional: True
     */
    @JsonProperty("comment")
    private String comment;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("realm")
    private String realm;

    /**
     * Two-factor authentication provider.
     * Type: string
     * Optional: True
     */
    @JsonProperty("tfa")
    private String tfa;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;


}
