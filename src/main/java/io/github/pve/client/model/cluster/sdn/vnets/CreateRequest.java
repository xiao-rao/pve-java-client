package io.github.pve.client.model.cluster.sdn.vnets;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotNull;

/**
 * Create a new sdn vnet object.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateRequest {

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
     * Type
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;

    /**
     * Allow vm VLANs to pass through this vnet.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("vlanaware")
    private Boolean vlanaware;

    /**
     * The SDN vnet object identifier.
     * Type: string
     * Optional: True
     */
    @JsonProperty("vnet")
    private String vnet;

    /**
     * zone id
     * Type: string
     * Optional: False
     */
    @NotNull(message = "Parameter 'zone' must not be null")
    @JsonProperty("zone")
    private String zone;


}
