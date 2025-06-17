package io.github.pve.client.model.cluster.sdn.vnets;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

/**
 * Update sdn vnet object configuration.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateRequest {

    /**
     * alias name of the vnet
     * Type: string
     * Optional: True
     */
    @Size(max=256, message="Parameter 'alias' length must not exceed 256")
    @Pattern(regexp="(?^i:[\\(\\)-_.\\w\\d\\s]{0,256})", message="Parameter 'alias' does not match pattern")
    @JsonProperty("alias")
    private String alias;

    /**
     * A list of settings you want to delete.
     * Type: string
     * Optional: True
     */
    @Size(max=4096, message="Parameter 'delete' length must not exceed 4096")
    @JsonProperty("delete")
    private String delete;

    /**
     * Prevent changes if current configuration file has a different digest. This can be used to prevent concurrent modifications.
     * Type: string
     * Optional: True
     */
    @Size(max=64, message="Parameter 'digest' length must not exceed 64")
    @JsonProperty("digest")
    private String digest;

    /**
     * If true, sets the isolated property for all members of this VNet
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("isolate-ports")
    private Boolean isolatePorts;

    /**
     * vlan or vxlan id
     * Type: integer
     * Optional: True
     */
    @JsonProperty("tag")
    private Integer tag;

    /**
     * Allow vm VLANs to pass through this vnet.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("vlanaware")
    private Boolean vlanaware;

    /**
     * zone id
     * Type: string
     * Optional: True
     */
    @JsonProperty("zone")
    private String zone;

    /**
     * Path parameter: vnet
     * Type: string
     * Optional: True
     */
    @JsonProperty("vnet")
    private String vnet;


}
