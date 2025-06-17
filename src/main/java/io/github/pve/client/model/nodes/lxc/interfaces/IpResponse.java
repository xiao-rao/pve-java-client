package io.github.pve.client.model.nodes.lxc.interfaces;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * Get IP addresses of the specified container interface.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IpResponse {

    /**
     * The MAC address of the interface
     * Type: string
     * Optional: False
     */
    @JsonProperty("hardware-address")
    private String hardwareAddress;

    /**
     * The MAC address of the interface
     * Type: string
     * Optional: False
     */
    @JsonProperty("hwaddr")
    private String hwaddr;

    /**
     * The IPv4 address of the interface
     * Type: string
     * Optional: True
     */
    @JsonProperty("inet")
    private String inet;

    /**
     * The IPv6 address of the interface
     * Type: string
     * Optional: True
     */
    @JsonProperty("inet6")
    private String inet6;

    /**
     * The addresses of the interface
     * Type: array
     * Optional: False
     */
    @JsonProperty("ip-addresses")
    private List<Object> ipAddresses;

    /**
     * The name of the interface
     * Type: string
     * Optional: False
     */
    @JsonProperty("name")
    private String name;


}
