package io.github.pve.client.model.nodes.firewall.options;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Get host firewall options.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetOptionsResponse {

    /**
     * Enable host firewall rules.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("enable")
    private Boolean enable;

    /**
     * Log level for forwarded traffic.
     * Type: string
     * Optional: True
     */
    @JsonProperty("log_level_forward")
    private String logLevelForward;

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
     * Enable logging of conntrack information.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("log_nf_conntrack")
    private Boolean logNfConntrack;

    /**
     * Enable NDP (Neighbor Discovery Protocol).
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("ndp")
    private Boolean ndp;

    /**
     * Allow invalid packets on connection tracking.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("nf_conntrack_allow_invalid")
    private Boolean nfConntrackAllowInvalid;

    /**
     * Enable conntrack helpers for specific protocols. Supported protocols: amanda, ftp, irc, netbios-ns, pptp, sane, sip, snmp, tftp
     * Type: string
     * Optional: True
     */
    @JsonProperty("nf_conntrack_helpers")
    private String nfConntrackHelpers;

    /**
     * Maximum number of tracked connections.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("nf_conntrack_max")
    private Integer nfConntrackMax;

    /**
     * Conntrack established timeout.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("nf_conntrack_tcp_timeout_established")
    private Integer nfConntrackTcpTimeoutEstablished;

    /**
     * Conntrack syn recv timeout.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("nf_conntrack_tcp_timeout_syn_recv")
    private Integer nfConntrackTcpTimeoutSynRecv;

    /**
     * Enable nftables based firewall (tech preview)
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("nftables")
    private Boolean nftables;

    /**
     * Enable SMURFS filter.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("nosmurfs")
    private Boolean nosmurfs;

    /**
     * Enable synflood protection
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("protection_synflood")
    private Boolean protectionSynflood;

    /**
     * Synflood protection rate burst by ip src.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("protection_synflood_burst")
    private Integer protectionSynfloodBurst;

    /**
     * Synflood protection rate syn/sec by ip src.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("protection_synflood_rate")
    private Integer protectionSynfloodRate;

    /**
     * Log level for SMURFS filter.
     * Type: string
     * Optional: True
     */
    @JsonProperty("smurf_log_level")
    private String smurfLogLevel;

    /**
     * Log level for illegal tcp flags filter.
     * Type: string
     * Optional: True
     */
    @JsonProperty("tcp_flags_log_level")
    private String tcpFlagsLogLevel;

    /**
     * Filter illegal combinations of TCP flags.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("tcpflags")
    private Boolean tcpflags;


}
