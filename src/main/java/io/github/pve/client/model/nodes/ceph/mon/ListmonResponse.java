package io.github.pve.client.model.nodes.ceph.mon;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Get Ceph monitor list.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListmonResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("addr")
    private String addr;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("ceph_version")
    private String cephVersion;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("ceph_version_short")
    private String cephVersionShort;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("direxists")
    private String direxists;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("host")
    private Boolean host;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("quorum")
    private Boolean quorum;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("rank")
    private Integer rank;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("service")
    private Integer service;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("state")
    private String state;


}
