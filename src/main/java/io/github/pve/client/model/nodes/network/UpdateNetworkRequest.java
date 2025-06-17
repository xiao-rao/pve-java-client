package io.github.pve.client.model.nodes.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;

/**
 * Update network device configuration
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateNetworkRequest {

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
     * A list of settings you want to delete.
     * Type: string
     * Optional: True
     */
    @JsonProperty("delete")
    private String delete;

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
    @Size(max=1024, message="Parameter 'ovs_options' length must not exceed 1024")
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
     * vlan-id for a custom named vlan interface (ifupdown2 only).
     * Type: integer
     * Optional: True
     */
    @JsonProperty("vlan-id")
    private Integer vlanId;

    /**
     * Specify the raw interface for the vlan interface.
     * Type: string
     * Optional: True
     */
    @JsonProperty("vlan-raw-device")
    private String vlanRawDevice;

    /**
     * Path parameter: iface
     * Type: string
     * Optional: True
     */
    @JsonProperty("iface")
    private String iface;


}
