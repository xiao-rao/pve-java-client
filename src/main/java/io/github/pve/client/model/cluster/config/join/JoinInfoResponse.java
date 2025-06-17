package io.github.pve.client.model.cluster.config.join;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Get information needed to join this cluster over the connected node.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JoinInfoResponse {

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("config_digest")
    private String configDigest;

    /**
     * 
     * Type: array
     * Optional: True
     */
    @JsonProperty("nodelist")
    private List<Object> nodelist;

    /**
     * The cluster node name.
     * Type: string
     * Optional: True
     */
    @JsonProperty("preferred_node")
    private String preferredNode;

    /**
     * 
     * Type: object
     * Optional: True
     */
    @JsonProperty("totem")
    private Map<String, Object> totem;


}
