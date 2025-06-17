package io.github.pve.client.model.cluster.sdn.vnets.ips;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Update IP Mapping in a VNet
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IpupdateRequest {

    /**
     * The IP address to associate with the given MAC address
     * Type: string
     * Optional: True
     */
    @JsonProperty("ip")
    private String ip;

    /**
     * Unicast MAC address.
     * Type: string
     * Optional: True
     */
    @JsonProperty("mac")
    private String mac;

    /**
     * The SDN zone object identifier.
     * Type: string
     * Optional: True
     */
    @JsonProperty("zone")
    private String zone;

    /**
     * Path parameter: vmid
     * Type: string
     * Optional: True
     */
    @JsonProperty("vmid")
    private String vmid;


}
