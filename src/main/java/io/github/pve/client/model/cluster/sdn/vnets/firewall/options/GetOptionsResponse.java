package io.github.pve.client.model.cluster.sdn.vnets.firewall.options;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Get vnet firewall options.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetOptionsResponse {

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
