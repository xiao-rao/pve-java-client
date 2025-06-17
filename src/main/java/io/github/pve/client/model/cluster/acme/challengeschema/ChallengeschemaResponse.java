package io.github.pve.client.model.cluster.acme.challengeschema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.Map;
import java.util.HashMap;

/**
 * Get schema of ACME challenge types.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChallengeschemaResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("id")
    private String id;

    /**
     * Human readable name, falls back to id
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;

    /**
     * 
     * Type: object
     * Optional: True
     */
    @JsonProperty("schema")
    private Map<String, Object> schema;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;


}
