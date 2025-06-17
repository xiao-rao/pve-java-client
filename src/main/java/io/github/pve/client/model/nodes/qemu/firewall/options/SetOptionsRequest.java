package io.github.pve.client.model.nodes.qemu.firewall.options;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;

/**
 * Set Firewall options.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SetOptionsRequest {

    /**
     * A list of settings you want to delete.
     * Type: string
     * Optional: True
     */
    @JsonProperty("delete")
    private String delete;

    /**
     * Enable DHCP.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("dhcp")
    private Boolean dhcp;

    /**
     * Prevent changes if current configuration file has a different digest. This can be used to prevent concurrent modifications.
     * Type: string
     * Optional: True
     */
    @Size(max=64, message="Parameter 'digest' length must not exceed 64")
    @JsonProperty("digest")
    private String digest;

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
