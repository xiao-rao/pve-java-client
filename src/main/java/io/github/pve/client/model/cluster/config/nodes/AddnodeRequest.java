package io.github.pve.client.model.cluster.config.nodes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Builder;
import lombok.Data;
import java.util.Map;
import java.util.HashMap;

/**
 * Adds a node to the cluster configuration. This call is for internal use.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddnodeRequest {

    /**
     * The JOIN_API_VERSION of the new node.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("apiversion")
    private Integer apiversion;

    /**
     * Do not throw error if node already exists.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("force")
    private Boolean force;

    /**
     * Address and priority information of a single corosync link. (up to 8 links supported; link0..link7) (Array parameter: use Map with integer keys for link0, link1, etc.)
     * Type: object
     * Optional: True
     */
    @JsonProperty("link")
    private Map<Integer, String> link;

    /**
     * IP Address of node to add. Used as fallback if no links are given.
     * Type: string
     * Optional: True
     */
    @JsonProperty("new_node_ip")
    private String newNodeIp;

    /**
     * Node id for this node.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("nodeid")
    private Integer nodeid;

    /**
     * Number of votes for this node
     * Type: integer
     * Optional: True
     */
    @JsonProperty("votes")
    private Integer votes;

    /**
     * Path parameter: node
     * Type: string
     * Optional: True
     */
    @JsonProperty("node")
    private String node;


    
    // Custom JSON handling for array parameters
    @JsonAnySetter
    public void setArrayParameter(String key, Object value) {
        if (key.startsWith("link")) {
            if (this.link == null) {
                this.link = new HashMap<>();
            }
            try {
                String indexStr = key.substring(4);
                Integer index = Integer.parseInt(indexStr);
                this.link.put(index, String.valueOf(value));
            } catch (NumberFormatException e) {
                // Skip invalid index
            }
        }
    }
    
    @JsonAnyGetter
    public Map<String, Object> getArrayParameters() {
        Map<String, Object> result = new HashMap<>();
        if (this.link != null) {
            this.link.forEach((index, value) -> 
                result.put("link" + index, value));
        }
        return result;
    }
}
