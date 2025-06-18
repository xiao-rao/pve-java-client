package io.github.pve.client.model.nodes.ceph.mds;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * MDS directory index.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CephMdsIndexResponse {

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
    @JsonProperty("host")
    private String host;

    /**
     * The name (ID) for the MDS
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("rank")
    private Integer rank;

    /**
     * If true, the standby MDS is polling the active MDS for faster recovery (hot standby).
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("standby_replay")
    private Boolean standbyReplay;

    /**
     * State of the MDS
     * Type: string
     * Optional: True
     */
    @JsonProperty("state")
    private String state;


}
