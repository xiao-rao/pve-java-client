package io.github.pve.client.model.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 节点上的网络设备信息
 * Corresponds to an item in the response from GET /nodes/{node}/network
 * This model is comprehensive to handle various device types like bridges, bonds, VLANs, etc.
 */
@Data
public class NetworkDevice {

    /**
     * Network interface name.
     */
    @JsonProperty("iface")
    private String interfaceName;

    /**
     * The network device type.
     */
    private String type;

    /**
     * Interface is active.
     */
    private Integer active;

    /**
     * Autostart interface.
     */
    private Integer autostart;

    /**
     * The IP address.
     */
    private String address;

    /**
     * The IP address for IPv6.
     */
    private String address6;

    /**
     * The network mask.
     */
    private String netmask;

    /**
     * The network mask for IPv6.
     */
    private Integer netmask6;

    /**
     * The default gateway.
     */
    private String gateway;

    /**
     * The default gateway for IPv6.
     */
    private String gateway6;

    /**
     * Network configuration method.
     */
    private String method;

    /**
     * Network configuration method for IPv6.
     */
    private String method6;

    /**
     * List of bonded slaves.
     */
    private String slaves;

    /**
     * List of bridge ports.
     */
    @JsonProperty("bridge_ports")
    private String bridgePorts;

    /**

     * This bridge has a VLAN aware.
     */
    @JsonProperty("bridge-vlan-aware")
    private Integer bridgeVlanAware;

    /**
     * The CIDR network address.
     */
    private String cidr;

    /**
     * The CIDR network address for IPv6.
     */
    private String cidr6;

    /**
     * Comments of the network device.
     */
    private String comments;

    /**
     * The bond mode.
     */
    @JsonProperty("bond-mode")
    private String bondMode;

    /**
     * The bond primary interface.
     */
    @JsonProperty("bond_primary")
    private String bondPrimary;

    /**
     * The bond transmit hash policy.
     */
    @JsonProperty("bond_xmit_hash_policy")
    private String bondXmitHashPolicy;

    /**
     * MTU of the network device.
     */
    private Integer mtu;

    /**
     * VLAN ID for VLAN interfaces.
     */
    @JsonProperty("vlan-id")
    private Integer vlanId;

    /**
     * The raw VLAN device this interface is based on.
     */
    @JsonProperty("vlan-raw-device")
    private String vlanRawDevice;
}

