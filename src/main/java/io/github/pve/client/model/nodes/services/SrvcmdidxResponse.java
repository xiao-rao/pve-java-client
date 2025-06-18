package io.github.pve.client.model.nodes.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Directory index
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SrvcmdidxResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("subdir")
    private String subdir;


}
