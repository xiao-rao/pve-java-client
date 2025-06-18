package io.github.pve.client.model.nodes.apt;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Directory index for apt (Advanced Package Tool).
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NodesAptIndexResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("id")
    private String id;


}
