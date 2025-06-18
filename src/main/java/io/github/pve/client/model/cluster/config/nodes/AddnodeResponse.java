package io.github.pve.client.model.cluster.config.nodes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * Adds a node to the cluster configuration. This call is for internal use.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddnodeResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("corosync_authkey")
    private String corosyncAuthkey;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("corosync_conf")
    private String corosyncConf;

    /**
     * 
     * Type: array
     * Optional: True
     */
    @JsonProperty("warnings")
    private List<String> warnings;


}
