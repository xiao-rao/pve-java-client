package io.github.pve.client.model.nodes.capabilities.qemu.machines;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Get available QEMU/KVM machine types.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TypesResponse {

    /**
     * Notable changes of a version, currently only set for +pveX versions.
     * Type: string
     * Optional: True
     */
    @JsonProperty("changes")
    private String changes;

    /**
     * Full name of machine type and version.
     * Type: string
     * Optional: True
     */
    @JsonProperty("id")
    private String id;

    /**
     * The machine type.
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;

    /**
     * The machine version.
     * Type: string
     * Optional: True
     */
    @JsonProperty("version")
    private String version;


}
