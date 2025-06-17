package io.github.pve.client.model.nodes.ceph.pool.status;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Show the current pool status.
 * BY '@xiao-rao'
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetpoolResponse {

    /**
     * The application of the pool.
     * Type: string
     * Optional: True
     */
    @JsonProperty("application")
    private String application;

    /**
     * 
     * Type: array
     * Optional: True
     */
    @JsonProperty("application_list")
    private List<Object> applicationList;

    /**
     * 
     * Type: object
     * Optional: True
     */
    @JsonProperty("autoscale_status")
    private Map<String, Object> autoscaleStatus;

    /**
     * The rule to use for mapping object placement in the cluster.
     * Type: string
     * Optional: True
     */
    @JsonProperty("crush_rule")
    private String crushRule;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("fast_read")
    private Boolean fastRead;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("hashpspool")
    private Boolean hashpspool;

    /**
     * 
     * Type: integer
     * Optional: True
     */
    @JsonProperty("id")
    private Integer id;

    /**
     * Minimum number of replicas per object
     * Type: integer
     * Optional: True
     */
    @JsonProperty("min_size")
    private Integer minSize;

    /**
     * The name of the pool. It must be unique.
     * Type: string
     * Optional: True
     */
    @JsonProperty("name")
    private String name;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("nodeep-scrub")
    private Boolean nodeepScrub;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("nodelete")
    private Boolean nodelete;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("nopgchange")
    private Boolean nopgchange;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("noscrub")
    private Boolean noscrub;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("nosizechange")
    private Boolean nosizechange;

    /**
     * The automatic PG scaling mode of the pool.
     * Type: string
     * Optional: True
     */
    @JsonProperty("pg_autoscale_mode")
    private String pgAutoscaleMode;

    /**
     * Number of placement groups.
     * Type: integer
     * Optional: True
     */
    @JsonProperty("pg_num")
    private Integer pgNum;

    /**
     * Minimal number of placement groups.
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
    @JsonProperty("pgp_num")
    private Integer pgpNum;

    /**
     * Number of replicas per object
     * Type: integer
     * Optional: True
     */
    @JsonProperty("size")
    private Integer size;

    /**
     * 
     * Type: object
     * Optional: True
     */
    @JsonProperty("statistics")
    private Map<String, Object> statistics;

    /**
     * The estimated target size of the pool for the PG autoscaler.
     * Type: string
     * Optional: True
     */
    @JsonProperty("target_size")
    private String targetSize;

    /**
     * The estimated target ratio of the pool for the PG autoscaler.
     * Type: number
     * Optional: True
     */
    @JsonProperty("target_size_ratio")
    private Double targetSizeRatio;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("use_gmt_hitset")
    private Boolean useGmtHitset;

    /**
     * 
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("write_fadvise_dontneed")
    private Boolean writeFadviseDontneed;


}
