package io.github.pve.client.model.cluster.acme.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.Map;
import java.util.HashMap;

/**
 * Return existing ACME account information.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetAccountResponse {

    /**
     * 
     * Type: object
     * Optional: True
     */
    @JsonProperty("account")
    private Map<String, Object> account;

    /**
     * URL of ACME CA directory endpoint.
     * Type: string
     * Optional: True
     */
    @JsonProperty("directory")
    private String directory;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("location")
    private String location;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("tos")
    private String tos;


}
