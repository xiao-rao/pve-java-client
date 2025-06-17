package io.github.pve.client.model.cluster.sdn.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Create a new sdn controller object.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateRequest {

    /**
     * autonomous system number
     * Type: integer
     * Optional: True
     */
    @JsonProperty("asn")
    private Integer asn;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("bgp-multipath-as-path-relax")
    private Boolean bgpMultipathAsPathRelax;

    /**
     * The SDN controller object identifier.
     * Type: string
     * Optional: True
     */
    @JsonProperty("controller")
    private String controller;

    /**
     * Enable ebgp. (remote-as external)
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("ebgp")
    private Boolean ebgp;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("ebgp-multihop")
    private Integer ebgpMultihop;

    /**
     * ISIS domain.
     * Type: string
     * Optional: True
     */
    @JsonProperty("isis-domain")
    private String isisDomain;

    /**
     * ISIS interface.
     * Type: string
     * Optional: True
     */
    @JsonProperty("isis-ifaces")
    private String isisIfaces;

    /**
     * ISIS network entity title.
     * Type: string
     * Optional: True
     */
    @JsonProperty("isis-net")
    private String isisNet;

    /**
     * source loopback interface.
     * Type: string
     * Optional: True
     */
    @JsonProperty("loopback")
    private String loopback;

    /**
     * The cluster node name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("node")
    private String node;

    /**
     * peers address list.
     * Type: string
     * Optional: True
     */
    @JsonProperty("peers")
    private String peers;

    /**
     * Plugin type.
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;


}
