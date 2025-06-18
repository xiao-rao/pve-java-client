package io.github.pve.client.model.access.users.token;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Generate a new API token for a specific user. NOTE: returns API token value, which needs to be stored as it cannot be retrieved afterwards!
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenerateTokenRequest {

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
     * Path parameter: tokenid
     * Type: string
     * Optional: True
     */
    @JsonProperty("tokenid")
    private String tokenId;


}
