package io.github.pve.client.model.cluster.sdn.vnets.subnets;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import java.util.List;

/**
 * Create a new sdn subnet object.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateRequest {

    /**
     * IP address for the DNS server
     * Type: string
     * Optional: True
     */
    @JsonProperty("dhcp-dns-server")
    private String dhcpDnsServer;

    /**
     * A list of DHCP ranges for this subnet
     * Type: array
     * Optional: True
     */
    @JsonProperty("dhcp-range")
    private List<String> dhcpRange;

    /**
     * dns domain zone prefix  ex: 'adm' -> <hostname>.adm.mydomain.com
     * Type: string
     * Optional: True
     */
    @JsonProperty("dnszoneprefix")
    private String dnszoneprefix;

    /**
     * Subnet Gateway: Will be assign on vnet for layer3 zones
     * Type: string
     * Optional: True
     */
    @JsonProperty("gateway")
    private String gateway;

    /**
     * enable masquerade for this subnet if pve-firewall
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("snat")
    private Boolean snat;

    /**
     * The SDN subnet object identifier.
     * Type: string
     * Optional: True
     */
    @JsonProperty("subnet")
    private String subnet;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;


}
