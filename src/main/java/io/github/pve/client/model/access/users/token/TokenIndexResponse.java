package io.github.pve.client.model.access.users.token;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Get user API tokens.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TokenIndexResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("comment")
    private String comment;

    /**
     * API token expiration date (seconds since epoch). '0' means no expiration date.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("expire")
    private Integer expire;

    /**
     * Restrict API token privileges with separate ACLs (default), or give full privileges of corresponding user.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("privsep")
    private Boolean privsep;

    /**
     * User-specific token identifier.
     * Type: string
     * Optional: True
     */
    @JsonProperty("tokenid")
    private String tokenId;


}
