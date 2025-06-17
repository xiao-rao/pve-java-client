package io.github.pve.client.model.nodes.lxc.firewall.rules;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Get single rule data.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetRuleResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("action")
    private String action;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("comment")
    private String comment;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("dest")
    private String dest;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("dport")
    private String dport;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("icmp-type")
    private String icmpType;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("iface")
    private String iface;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("ipversion")
    private Integer ipversion;

    /**
     * Log level for firewall rule
     * Type: string
     * Optional: True
     */
    @JsonProperty("log")
    private String log;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("macro")
    private String macro;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("pos")
    private Integer pos;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("proto")
    private String proto;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("source")
    private String source;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("sport")
    private String sport;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;


}
