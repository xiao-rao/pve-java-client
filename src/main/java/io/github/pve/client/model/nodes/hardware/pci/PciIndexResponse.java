package io.github.pve.client.model.nodes.hardware.pci;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Index of available pci methods
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PciIndexResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("method")
    private String method;


}
