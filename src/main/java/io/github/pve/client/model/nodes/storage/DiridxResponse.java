package io.github.pve.client.model.nodes.storage;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * 
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiridxResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("subdir")
    private String subdir;


}
