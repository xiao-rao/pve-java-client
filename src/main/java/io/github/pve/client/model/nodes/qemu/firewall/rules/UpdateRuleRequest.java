package io.github.pve.client.model.nodes.qemu.firewall.rules;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

/**
 * Modify rule data.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateRuleRequest {

    /**
     * Rule action ('ACCEPT', 'DROP', 'REJECT') or security group name.
     * Type: string
     * Optional: True
     */
    @Size(max=20, message="Parameter 'action' length must not exceed 20")
    @Pattern(regexp="[A-Za-z][A-Za-z0-9\\-\\_]+", message="Parameter 'action' does not match pattern")
    @JsonProperty("action")
    private String action;

    /**
     * Descriptive comment.
     * Type: string
     * Optional: True
     */
    @JsonProperty("comment")
    private String comment;

    /**
     * A list of settings you want to delete.
     * Type: string
     * Optional: True
     */
    @JsonProperty("delete")
    private String delete;

    /**
     * Restrict packet destination address. This can refer to a single IP address, an IP set ('+ipsetname') or an IP alias definition. You can also specify an address range like '20.34.101.207-201.3.9.99', or a list of IP addresses and networks (entries are separated by comma). Please do not mix IPv4 and IPv6 addresses inside such lists.
     * Type: string
     * Optional: True
     */
    @Size(max=512, message="Parameter 'dest' length must not exceed 512")
    @JsonProperty("dest")
    private String dest;

    /**
     * Prevent changes if current configuration file has a different digest. This can be used to prevent concurrent modifications.
     * Type: string
     * Optional: True
     */
    @Size(max=64, message="Parameter 'digest' length must not exceed 64")
    @JsonProperty("digest")
    private String digest;

    /**
     * Restrict TCP/UDP destination port. You can use service names or simple numbers (0-65535), as defined in '/etc/services'. Port ranges can be specified with '\d+:\d+', for example '80:85', and you can use comma separated list to match several ports or ranges.
     * Type: string
     * Optional: True
     */
    @JsonProperty("dport")
    private String dport;

    /**
     * Flag to enable/disable a rule.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("enable")
    private Integer enable;

    /**
     * Specify icmp-type. Only valid if proto equals 'icmp' or 'icmpv6'/'ipv6-icmp'.
     * Type: string
     * Optional: True
     */
    @JsonProperty("icmp-type")
    private String icmpType;

    /**
     * Network interface name. You have to use network configuration key names for VMs and containers ('net\d+'). Host related rules can use arbitrary strings.
     * Type: string
     * Optional: True
     */
    @Size(max=20, message="Parameter 'iface' length must not exceed 20")
    @JsonProperty("iface")
    private String iface;

    /**
     * Log level for firewall rule.
     * Type: string
     * Optional: True
     */
    @JsonProperty("log")
    private String log;

    /**
     * Use predefined standard macro.
     * Type: string
     * Optional: True
     */
    @Size(max=128, message="Parameter 'macro' length must not exceed 128")
    @JsonProperty("macro")
    private String macro;

    /**
     * Move rule to new position <moveto>. Other arguments are ignored.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("moveto")
    private Integer moveto;

    /**
     * IP protocol. You can use protocol names ('tcp'/'udp') or simple numbers, as defined in '/etc/protocols'.
     * Type: string
     * Optional: True
     */
    @JsonProperty("proto")
    private String proto;

    /**
     * Restrict packet source address. This can refer to a single IP address, an IP set ('+ipsetname') or an IP alias definition. You can also specify an address range like '20.34.101.207-201.3.9.99', or a list of IP addresses and networks (entries are separated by comma). Please do not mix IPv4 and IPv6 addresses inside such lists.
     * Type: string
     * Optional: True
     */
    @Size(max=512, message="Parameter 'source' length must not exceed 512")
    @JsonProperty("source")
    private String source;

    /**
     * Restrict TCP/UDP source port. You can use service names or simple numbers (0-65535), as defined in '/etc/services'. Port ranges can be specified with '\d+:\d+', for example '80:85', and you can use comma separated list to match several ports or ranges.
     * Type: string
     * Optional: True
     */
    @JsonProperty("sport")
    private String sport;

    /**
     * Rule type.
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;

    /**
     * Path parameter: pos
     * Type: string
     * Optional: True
     */
    @JsonProperty("pos")
    private String pos;


}
