package io.github.pve.client.model.nodes.ceph.mgr;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * MGR directory index.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CephMgrIndexResponse {

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
     * The name (ID) for the MGR
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;

    /**
     * State of the MGR
     * Type: string
     * Optional: True
     */
    @JsonProperty("state")
    private String state;


}
