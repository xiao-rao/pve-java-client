package io.github.pve.client.model.cluster.sdn.vnets.subnets;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import java.util.List;
import jakarta.validation.constraints.Size;

/**
 * Update sdn subnet object configuration.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateRequest {

    /**
     * A list of settings you want to delete.
     * Type: string
     * Optional: True
     */
    @Size(max=4096, message="Parameter 'delete' length must not exceed 4096")
    @JsonProperty("delete")
    private String delete;

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
     * Prevent changes if current configuration file has a different digest. This can be used to prevent concurrent modifications.
     * Type: string
     * Optional: True
     */
    @Size(max=64, message="Parameter 'digest' length must not exceed 64")
    @JsonProperty("digest")
    private String digest;

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
     * Path parameter: subnet
     * Type: string
     * Optional: True
     */
    @JsonProperty("subnet")
    private String subnet;


}
