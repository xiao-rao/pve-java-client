package io.github.pve.client.model.nodes.capabilities.qemu.cpu;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * List all custom and default CPU models.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QemuCpuIndexResponse {

    /**
     * True if this is a custom CPU model.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("custom")
    private Boolean custom;

    /**
     * Name of the CPU model. Identifies it for subsequent API calls. Prefixed with 'custom-' for custom models.
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;

    /**
     * CPU vendor visible to the guest when this model is selected. Vendor of 'reported-model' in case of custom models.
     * Type: string
     * Optional: True
     */
    @JsonProperty("vendor")
    private String vendor;


}
