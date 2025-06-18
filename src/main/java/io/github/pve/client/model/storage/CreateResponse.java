package io.github.pve.client.model.storage;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Create a new storage.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateResponse {

    /**
     * Partial, possible server generated, configuration properties.
     * Type: object
     * Optional: True
     */
    @JsonProperty("config")
    private Object config;

    /**
     * The ID of the created storage.
     * Type: string
     * Optional: True
     */
    @JsonProperty("storage")
    private String storage;

    /**
     * The type of the created storage.
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;


}
