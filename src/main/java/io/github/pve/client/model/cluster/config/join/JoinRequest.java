package io.github.pve.client.model.cluster.config.join;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Builder;
import lombok.Data;
import java.util.Map;
import java.util.HashMap;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

/**
 * Joins this node into an existing cluster. If no links are given, default to IP resolved by node's hostname on single link (fallback fails for clusters with multiple links).
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JoinRequest {

    /**
     * Certificate SHA 256 fingerprint.
     * Type: string
     * Optional: True
     */
    @Pattern(regexp="([A-Fa-f0-9]{2}:){31}[A-Fa-f0-9]{2}", message="Parameter 'fingerprint' does not match pattern")
    @JsonProperty("fingerprint")
    private String fingerprint;

    /**
     * Do not throw error if node already exists.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("force")
    private Boolean force;

    /**
     * Hostname (or IP) of an existing cluster member.
     * Type: string
     * Optional: True
     */
    @JsonProperty("hostname")
    private String hostname;

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
     * Superuser (root) password of peer node.
     * Type: string
     * Optional: True
     */
    @Size(max=128, message="Parameter 'password' length must not exceed 128")
    @JsonProperty("password")
    private String password;

    /**
     * Number of votes for this node
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
