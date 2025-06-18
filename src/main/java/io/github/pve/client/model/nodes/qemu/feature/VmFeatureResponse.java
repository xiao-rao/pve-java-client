package io.github.pve.client.model.nodes.qemu.feature;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

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

    /**
     * 
     * Type: array
     * Optional: True
     */
    @JsonProperty("nodes")
    private List<String> nodes;


}
