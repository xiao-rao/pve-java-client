package io.github.pve.client.model.cluster.sdn.zones;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * SDN zones index.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndexResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("dhcp")
    private String dhcp;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("dns")
    private String dns;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("dnszone")
    private String dnszone;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("ipam")
    private String ipam;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("mtu")
    private Integer mtu;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("nodes")
    private String nodes;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("pending")
    private Boolean pending;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("reversedns")
    private String reversedns;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("state")
    private String state;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("zone")
    private String zone;


}
