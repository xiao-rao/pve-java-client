package io.github.pve.client.model.nodes.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * List available networks
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NodesNetworkIndexResponse {

    /**
     * Set to true if the interface is active.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("active")
    private Boolean active;

    /**
     * IP address.
     * Type: string
     * Optional: True
     */
    @JsonProperty("address")
    private String address;

    /**
     * IP address.
     * Type: string
     * Optional: True
     */
    @JsonProperty("address6")
    private String address6;

    /**
     * Automatically start interface on boot.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("autostart")
    private Boolean autostart;

    /**
     * Specify the primary interface for active-backup bond.
     * Type: string
     * Optional: True
     */
    @JsonProperty("bond-primary")
    private String bondPrimary;

    /**
     * Bonding mode.
     * Type: string
     * Optional: True
     */
    @JsonProperty("bond_mode")
    private String bondMode;

    /**
     * Selects the transmit hash policy to use for slave selection in balance-xor and 802.3ad modes.
     * Type: string
     * Optional: True
     */
    @JsonProperty("bond_xmit_hash_policy")
    private String bondXmitHashPolicy;

    /**
     * The bridge port access VLAN.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("bridge-access")
    private Integer bridgeAccess;

    /**
     * Bridge port ARP/ND suppress flag.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("bridge-arp-nd-suppress")
    private Boolean bridgeArpNdSuppress;

    /**
     * Bridge port learning flag.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("bridge-learning")
    private Boolean bridgeLearning;

    /**
     * Bridge port multicast flood flag.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("bridge-multicast-flood")
    private Boolean bridgeMulticastFlood;

    /**
     * Bridge port unicast flood flag.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("bridge-unicast-flood")
    private Boolean bridgeUnicastFlood;

    /**
     * Specify the interfaces you want to add to your bridge.
     * Type: string
     * Optional: True
     */
    @JsonProperty("bridge_ports")
    private String bridgePorts;

    /**
     * Specify the allowed VLANs. For example: '2 4 100-200'. Only used if the bridge is VLAN aware.
     * Type: string
     * Optional: True
     */
    @JsonProperty("bridge_vids")
    private String bridgeVids;

    /**
     * Enable bridge vlan support.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("bridge_vlan_aware")
    private Boolean bridgeVlanAware;

    /**
     * IPv4 CIDR.
     * Type: string
     * Optional: True
     */
    @JsonProperty("cidr")
    private String cidr;

    /**
     * IPv6 CIDR.
     * Type: string
     * Optional: True
     */
    @JsonProperty("cidr6")
    private String cidr6;

    /**
     * Comments
     * Type: string
     * Optional: True
     */
    @JsonProperty("comments")
    private String comments;

    /**
     * Comments
     * Type: string
     * Optional: True
     */
    @JsonProperty("comments6")
    private String comments6;

    /**
     * Set to true if the interface physically exists.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("exists")
    private Boolean exists;

    /**
     * The network families.
     * Type: array
     * Optional: True
     */
    @JsonProperty("families")
    private List<String> families;

    /**
     * Default gateway address.
     * Type: string
     * Optional: True
     */
    @JsonProperty("gateway")
    private String gateway;

    /**
     * Default ipv6 gateway address.
     * Type: string
     * Optional: True
     */
    @JsonProperty("gateway6")
    private String gateway6;

    /**
     * Network interface name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("iface")
    private String iface;

    /**
     * The link type.
     * Type: string
     * Optional: True
     */
    @JsonProperty("link-type")
    private String linkType;

    /**
     * The network configuration method for IPv4.
     * Type: string
     * Optional: True
     */
    @JsonProperty("method")
    private String method;

    /**
     * The network configuration method for IPv6.
     * Type: string
     * Optional: True
     */
    @JsonProperty("method6")
    private String method6;

    /**
     * MTU.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("mtu")
    private Integer mtu;

    /**
     * Network mask.
     * Type: string
     * Optional: True
     */
    @JsonProperty("netmask")
    private String netmask;

    /**
     * Network mask.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("netmask6")
    private Integer netmask6;

    /**
     * A list of additional interface options for IPv4.
     * Type: array
     * Optional: True
     */
    @JsonProperty("options")
    private List<String> options;

    /**
     * A list of additional interface options for IPv6.
     * Type: array
     * Optional: True
     */
    @JsonProperty("options6")
    private List<String> options6;

    /**
     * Specify the interfaces used by the bonding device.
     * Type: string
     * Optional: True
     */
    @JsonProperty("ovs_bonds")
    private String ovsBonds;

    /**
     * The OVS bridge associated with a OVS port. This is required when you create an OVS port.
     * Type: string
     * Optional: True
     */
    @JsonProperty("ovs_bridge")
    private String ovsBridge;

    /**
     * OVS interface options.
     * Type: string
     * Optional: True
     */
    @JsonProperty("ovs_options")
    private String ovsOptions;

    /**
     * Specify the interfaces you want to add to your bridge.
     * Type: string
     * Optional: True
     */
    @JsonProperty("ovs_ports")
    private String ovsPorts;

    /**
     * Specify a VLan tag (used by OVSPort, OVSIntPort, OVSBond)
     * Type: integer
     * Optional: True
     */
    @JsonProperty("ovs_tag")
    private Integer ovsTag;

    /**
     * The order of the interface.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("priority")
    private Integer priority;

    /**
     * Specify the interfaces used by the bonding device.
     * Type: string
     * Optional: True
     */
    @JsonProperty("slaves")
    private String slaves;

    /**
     * Network interface type
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;

    /**
     * The uplink ID.
     * Type: string
     * Optional: True
     */
    @JsonProperty("uplink-id")
    private String uplinkId;

    /**
     * vlan-id for a custom named vlan interface (ifupdown2 only).
     * Type: integer
     * Optional: True
     */
    @JsonProperty("vlan-id")
    private Integer vlanId;

    /**
     * The VLAN protocol.
     * Type: string
     * Optional: True
     */
    @JsonProperty("vlan-protocol")
    private String vlanProtocol;

    /**
     * Specify the raw interface for the vlan interface.
     * Type: string
     * Optional: True
     */
    @JsonProperty("vlan-raw-device")
    private String vlanRawDevice;

    /**
     * The VXLAN ID.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("vxlan-id")
    private Integer vxlanId;

    /**
     * The VXLAN local tunnel IP.
     * Type: string
     * Optional: True
     */
    @JsonProperty("vxlan-local-tunnelip")
    private String vxlanLocalTunnelip;

    /**
     * The physical device for the VXLAN tunnel.
     * Type: string
     * Optional: True
     */
    @JsonProperty("vxlan-physdev")
    private String vxlanPhysdev;

    /**
     * The VXLAN SVC node IP.
     * Type: string
     * Optional: True
     */
    @JsonProperty("vxlan-svcnodeip")
    private String vxlanSvcnodeip;


}
