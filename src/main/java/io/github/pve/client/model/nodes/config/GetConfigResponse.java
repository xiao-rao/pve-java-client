package io.github.pve.client.model.nodes.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Data;
import java.util.Map;
import java.util.HashMap;

/**
 * Get node configuration options.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetConfigResponse {

    /**
     * Node specific ACME settings.
     * Type: string
     * Optional: True
     */
    @JsonProperty("acme")
    private String acme;

    /**
     * ACME domain and validation plugin (Array parameter: use Map with integer keys for acmedomain0, acmedomain1, etc.)
     * Type: object
     * Optional: True
     */
    @JsonProperty("acmedomain")
    private Map<Integer, String> acmedomain;

    /**
     * RAM usage target for ballooning (in percent of total memory)
     * Type: integer
     * Optional: True
     */
    @JsonProperty("ballooning-target")
    private Integer ballooningTarget;

    /**
     * Description for the Node. Shown in the web-interface node notes panel. This is saved as comment inside the configuration file.
     * Type: string
     * Optional: True
     */
    @JsonProperty("description")
    private String description;

    /**
     * Prevent changes if current configuration file has different SHA1 digest. This can be used to prevent concurrent modifications.
     * Type: string
     * Optional: True
     */
    @JsonProperty("digest")
    private String digest;

    /**
     * Initial delay in seconds, before starting all the Virtual Guests with on-boot enabled.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("startall-onboot-delay")
    private Integer startallOnbootDelay;

    /**
     * Node specific wake on LAN settings.
     * Type: string
     * Optional: True
     */
    @JsonProperty("wakeonlan")
    private String wakeonlan;


    
    // Custom JSON handling for array parameters
    @JsonAnySetter
    public void setArrayParameter(String key, Object value) {
        if (key.startsWith("acmedomain")) {
            if (this.acmedomain == null) {
                this.acmedomain = new HashMap<>();
            }
            try {
                String indexStr = key.substring(10);
                Integer index = Integer.parseInt(indexStr);
                this.acmedomain.put(index, String.valueOf(value));
            } catch (NumberFormatException e) {
                // Skip invalid index
            }
        }
    }
    
    @JsonAnyGetter
    public Map<String, Object> getArrayParameters() {
        Map<String, Object> result = new HashMap<>();
        if (this.acmedomain != null) {
            this.acmedomain.forEach((index, value) -> 
                result.put("acmedomain" + index, value));
        }
        return result;
    }
}
