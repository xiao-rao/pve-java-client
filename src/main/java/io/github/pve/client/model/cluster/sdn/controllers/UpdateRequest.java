package io.github.pve.client.model.cluster.sdn.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;

/**
 * Update sdn controller object configuration.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateRequest {

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
     * A list of settings you want to delete.
     * Type: string
     * Optional: True
     */
    @Size(max=4096, message="Parameter 'delete' length must not exceed 4096")
    @JsonProperty("delete")
    private String delete;

    /**
     * Prevent changes if current configuration file has a different digest. This can be used to prevent concurrent modifications.
     * Type: string
     * Optional: True
     */
    @Size(max=64, message="Parameter 'digest' length must not exceed 64")
    @JsonProperty("digest")
    private String digest;

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
     * Path parameter: controller
     * Type: string
     * Optional: True
     */
    @JsonProperty("controller")
    private String controller;


}
