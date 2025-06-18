package io.github.pve.client.model.cluster.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Builder;
import lombok.Data;
import java.util.Map;
import java.util.HashMap;
import jakarta.validation.constraints.Size;

/**
 * Generate new cluster configuration. If no links given, default to local IP address as link0.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateRequest {

    /**
     * The name of the cluster.
     * Type: string
     * Optional: True
     */
    @Size(max=15, message="Parameter 'clustername' length must not exceed 15")
    @JsonProperty("clustername")
    private String clustername;

    /**
     * Address and priority information of a single corosync link. (up to 8 links supported; link0..link7) (Array parameter: use Map with integer keys for link0, link1, etc.)
     * Type: object
     * Optional: True
     */
    @JsonProperty("link")
    private Map<Integer, String> link;

    /**
     * Node id for this node.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("nodeid")
    private Integer nodeId;

    /**
     * Number of votes for this node.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("votes")
    private Integer votes;


    
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
