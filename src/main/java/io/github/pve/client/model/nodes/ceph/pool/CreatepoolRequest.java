package io.github.pve.client.model.nodes.ceph.pool;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Pattern;

/**
 * Create Ceph pool
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreatepoolRequest {

    /**
     * Configure VM and CT storage using the new pool.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("add_storages")
    private Boolean addStorages;

    /**
     * The application of the pool.
     * Type: string
     * Optional: True
     */
    @JsonProperty("application")
    private String application;

    /**
     * The rule to use for mapping object placement in the cluster.
     * Type: string
     * Optional: True
     */
    @JsonProperty("crush_rule")
    private String crushRule;

    /**
     * Create an erasure coded pool for RBD with an accompaning replicated pool for metadata storage. With EC, the common ceph options 'size', 'min_size' and 'crush_rule' parameters will be applied to the metadata pool.
     * Type: string
     * Optional: True
     */
    @JsonProperty("erasure-coding")
    private String erasureCoding;

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
    @Pattern(regexp="(?^:^[^:/\\s]+$)", message="Parameter 'name' does not match pattern")
    @JsonProperty("name")
    private String name;

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
     * Number of replicas per object
     * Type: integer
     * Optional: True
     */
    @JsonProperty("size")
    private Integer size;

    /**
     * The estimated target size of the pool for the PG autoscaler.
     * Type: string
     * Optional: True
     */
    @Pattern(regexp="^(\\d+(\\.\\d+)?)([KMGT])?$", message="Parameter 'target_size' does not match pattern")
    @JsonProperty("target_size")
    private String targetSize;

    /**
     * The estimated target ratio of the pool for the PG autoscaler.
     * Type: number
     * Optional: True
     */
    @JsonProperty("target_size_ratio")
    private Double targetSizeRatio;


}
