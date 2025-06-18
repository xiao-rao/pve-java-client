package io.github.pve.client.model.nodes.lxc.feature;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Check if feature for virtual machine is available.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VmFeatureResponse {

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("hasFeature")
    private Boolean hasfeature;


}
