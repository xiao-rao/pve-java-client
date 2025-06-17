package io.github.pve.client.model.nodes.ceph.pool;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.Map;
import java.util.HashMap;

/**
 * List all pools and their settings (which are settable by the POST/PUT endpoints).
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LspoolsResponse {

    /**
     * 
     * Type: object
     * Optional: True
     */
    @JsonProperty("application_metadata")
    private Map<String, Object> applicationMetadata;

    /**
     * 
     * Type: object
     * Optional: True
     */
    @JsonProperty("autoscale_status")
    private Map<String, Object> autoscaleStatus;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("bytes_used")
    private Integer bytesUsed;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("crush_rule")
    private Integer crushRule;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("crush_rule_name")
    private String crushRuleName;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("min_size")
    private Integer minSize;

    /**
     * 
     * Type: number
     * Optional: True
     */
    @JsonProperty("percent_used")
    private Double percentUsed;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("pg_autoscale_mode")
    private String pgAutoscaleMode;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("pg_num")
    private Integer pgNum;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("pg_num_final")
    private Integer pgNumFinal;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("pg_num_min")
    private Integer pgNumMin;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("pool")
    private Integer pool;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("pool_name")
    private String poolName;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("size")
    private Integer size;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("target_size")
    private Integer targetSize;

    /**
     * 
     * Type: number
     * Optional: True
     */
    @JsonProperty("target_size_ratio")
    private Double targetSizeRatio;

    /**
     * 
     * Type: string
     * Optional: True
     */
    @JsonProperty("type")
    private String type;


}
