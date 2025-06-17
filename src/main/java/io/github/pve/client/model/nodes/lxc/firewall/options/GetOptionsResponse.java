package io.github.pve.client.model.nodes.lxc.firewall.options;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Get VM firewall options.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetOptionsResponse {

    /**
     * Enable DHCP.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("dhcp")
    private Boolean dhcp;

    /**
     * Enable/disable firewall rules.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("enable")
    private Boolean enable;

    /**
     * Enable default IP filters. This is equivalent to adding an empty ipfilter-net<id> ipset for every interface. Such ipsets implicitly contain sane default restrictions such as restricting IPv6 link local addresses to the one derived from the interface's MAC address. For containers the configured IP addresses will be implicitly added.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("ipfilter")
    private Boolean ipfilter;

    /**
     * Log level for incoming traffic.
     * Type: string
     * Optional: True
     */
    @JsonProperty("log_level_in")
    private String logLevelIn;

    /**
     * Log level for outgoing traffic.
     * Type: string
     * Optional: True
     */
    @JsonProperty("log_level_out")
    private String logLevelOut;

    /**
     * Enable/disable MAC address filter.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("macfilter")
    private Boolean macfilter;

    /**
     * Enable NDP (Neighbor Discovery Protocol).
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("ndp")
    private Boolean ndp;

    /**
     * Input policy.
     * Type: string
     * Optional: True
     */
    @JsonProperty("policy_in")
    private String policyIn;

    /**
     * Output policy.
     * Type: string
     * Optional: True
     */
    @JsonProperty("policy_out")
    private String policyOut;

    /**
     * Allow sending Router Advertisement.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("radv")
    private Boolean radv;


}
