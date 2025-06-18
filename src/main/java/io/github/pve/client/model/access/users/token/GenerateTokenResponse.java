package io.github.pve.client.model.access.users.token;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Generate a new API token for a specific user. NOTE: returns API token value, which needs to be stored as it cannot be retrieved afterwards!
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenerateTokenResponse {

    /**
     * The full token id.
     * Type: string
     * Optional: True
     */
    @JsonProperty("full-tokenid")
    private String fullTokenId;

    /**
     * 
     * Type: object
     * Optional: True
     */
    @JsonProperty("info")
    private Object info;

    /**
     * API token value used for authentication.
     * Type: string
     * Optional: True
     */
    @JsonProperty("value")
    private String value;


}
