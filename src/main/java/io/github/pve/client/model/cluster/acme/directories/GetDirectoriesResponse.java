package io.github.pve.client.model.cluster.acme.directories;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Get named known ACME directory endpoints.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetDirectoriesResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;

    /**
     * URL of ACME CA directory endpoint.
     * Type: string
     * Optional: True
     */
    @JsonProperty("url")
    private String url;


}
