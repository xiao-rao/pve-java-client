package io.github.pve.client.model.cluster.sdn.vnets.firewall.options;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Size;

/**
 * Set Firewall options.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SetOptionsRequest {

    /**
     * A list of settings you want to delete.
     * Type: string
     * Optional: True
     */
    @JsonProperty("delete")
    private String delete;

    /**
     * Prevent changes if current configuration file has a different digest. This can be used to prevent concurrent modifications.
     * Type: string
     * Optional: True
     */
    @Size(max=64, message="Parameter 'digest' length must not exceed 64")
    @JsonProperty("digest")
    private String digest;

    /**
     * Enable/disable firewall rules.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("enable")
    private Boolean enable;

    /**
     * Log level for forwarded traffic.
     * Type: string
     * Optional: True
     */
    @JsonProperty("log_level_forward")
    private String logLevelForward;

    /**
     * Forward policy.
     * Type: string
     * Optional: True
     */
    @JsonProperty("policy_forward")
    private String policyForward;


}
