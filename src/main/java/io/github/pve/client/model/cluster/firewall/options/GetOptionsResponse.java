package io.github.pve.client.model.cluster.firewall.options;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Get Firewall options.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetOptionsResponse {

    /**
     * Enable ebtables rules cluster wide.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("ebtables")
    private Boolean ebtables;

    /**
     * Enable or disable the firewall cluster wide.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("enable")
    private Integer enable;

    /**
     * Log ratelimiting settings
     * Type: string
     * Optional: True
     */
    @JsonProperty("log_ratelimit")
    private String logRatelimit;

    /**
     * Forward policy.
     * Type: string
     * Optional: True
     */
    @JsonProperty("policy_forward")
    private String policyForward;

    /**
     * Input policy.
     * Type: string
     * Optional: True
     */
    @JsonProperty("policy_in")
    private String policyIn;

    /**
     * Output policy.
     * Type: string
     * Optional: True
     */
    @JsonProperty("policy_out")
    private String policyOut;


}
