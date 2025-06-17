package io.github.pve.client.model.cluster.sdn.zones;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;

/**
 * Update sdn zone object configuration.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateRequest {

    /**
     * Advertise evpn subnets if you have silent hosts
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("advertise-subnets")
    private Boolean advertiseSubnets;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("bridge")
    private String bridge;

    /**
     * Disable auto mac learning.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("bridge-disable-mac-learning")
    private Boolean bridgeDisableMacLearning;

    /**
     * Frr router name
     * Type: string
     * Optional: True
     */
    @JsonProperty("controller")
    private String controller;

    /**
     * A list of settings you want to delete.
     * Type: string
     * Optional: True
     */
    @Size(max=4096, message="Parameter 'delete' length must not exceed 4096")
    @JsonProperty("delete")
    private String delete;

    /**
     * Type of the DHCP backend for this zone
     * Type: string
     * Optional: True
     */
    @JsonProperty("dhcp")
    private String dhcp;

    /**
     * Prevent changes if current configuration file has a different digest. This can be used to prevent concurrent modifications.
     * Type: string
     * Optional: True
     */
    @Size(max=64, message="Parameter 'digest' length must not exceed 64")
    @JsonProperty("digest")
    private String digest;

    /**
     * Disable ipv4 arp && ipv6 neighbour discovery suppression
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("disable-arp-nd-suppression")
    private Boolean disableArpNdSuppression;

    /**
     * dns api server
     * Type: string
     * Optional: True
     */
    @JsonProperty("dns")
    private String dns;

    /**
     * dns domain zone  ex: mydomain.com
     * Type: string
     * Optional: True
     */
    @JsonProperty("dnszone")
    private String dnszone;

    /**
     * Faucet dataplane id
     * Type: integer
     * Optional: True
     */
    @JsonProperty("dp-id")
    private Integer dpId;

    /**
     * List of cluster node names.
     * Type: string
     * Optional: True
     */
    @JsonProperty("exitnodes")
    private String exitnodes;

    /**
     * Allow exitnodes to connect to evpn guests
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("exitnodes-local-routing")
    private Boolean exitnodesLocalRouting;

    /**
     * Force traffic to this exitnode first.
     * Type: string
     * Optional: True
     */
    @JsonProperty("exitnodes-primary")
    private String exitnodesPrimary;

    /**
     * use a specific ipam
     * Type: string
     * Optional: True
     */
    @JsonProperty("ipam")
    private String ipam;

    /**
     * Anycast logical router mac address
     * Type: string
     * Optional: True
     */
    @JsonProperty("mac")
    private String mac;

    /**
     * MTU
     * Type: integer
     * Optional: True
     */
    @JsonProperty("mtu")
    private Integer mtu;

    /**
     * List of cluster node names.
     * Type: string
     * Optional: True
     */
    @JsonProperty("nodes")
    private String nodes;

    /**
     * peers address list.
     * Type: string
     * Optional: True
     */
    @JsonProperty("peers")
    private String peers;

    /**
     * reverse dns api server
     * Type: string
     * Optional: True
     */
    @JsonProperty("reversedns")
    private String reversedns;

    /**
     * Route-Target import
     * Type: string
     * Optional: True
     */
    @JsonProperty("rt-import")
    private String rtImport;

    /**
     * Service-VLAN Tag
     * Type: integer
     * Optional: True
     */
    @JsonProperty("tag")
    private Integer tag;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("vlan-protocol")
    private String vlanProtocol;

    /**
     * l3vni.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("vrf-vxlan")
    private Integer vrfVxlan;

    /**
     * Vxlan tunnel udp port (default 4789).
     * Type: integer
     * Optional: True
     */
    @JsonProperty("vxlan-port")
    private Integer vxlanPort;

    /**
     * Path parameter: zone
     * Type: string
     * Optional: True
     */
    @JsonProperty("zone")
    private String zone;


}
