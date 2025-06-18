package io.github.pve.client.model.storage;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Storage index.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StorageIndexResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("storage")
    private String storage;


}
